package com.xunyu.sgip.code;

import com.xunyu.sgip.dto.Bind;
import com.xunyu.sgip.dto.BindResp;
import com.xunyu.sgip.dto.SGIPCommend;
import com.xunyu.sgip.utils.SGIPUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

public class DecodeAndEncoder extends MessageToMessageCodec<SGIPCommend, SGIPCommend> {

    /**
     * 编码
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, SGIPCommend obj, List<Object> out) throws Exception {

        /**
         * 便利对象中所有的Integer属性
         */
        try {
            Bind b = null;
            if (obj.getCommandID() == SGIPCommend.SGIP_BIND) {//bind
                //转码
                //b = (Bind)obj;
                b = (Bind) getSGIPCommendEncode(obj);//强制转换
                b.setLoginTypeByte(SGIPUtils.IntToByteArray2(b.getLoginType()));  //登录类型
                out.add(b);//放到缓存通道中
            } else if (obj.getCommandID() == SGIPCommend.SGIP_BIND_RESP) {//BindResp
                BindResp br = (BindResp) getSGIPCommendEncode(obj);//强制转换
                br.setResultByte(SGIPUtils.IntToByteArray2(br.getResult()));//响应状态
                out.add(br);//放到缓存通道中
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ReferenceCountUtil.release(obj);
        }
    }

    /**
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     * @author dth
     * 解码
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, SGIPCommend msg, List<Object> out) throws Exception {

        try {
            Bind b = null;
            if (msg.getCommandID() == SGIPCommend.SGIP_BIND) {
                //转码
                b = (Bind) getSGIPCommendDecode(msg);
                b.setLoginType(SGIPUtils.ByteArrayToInt2(b.getLoginTypeByte()));

                out.add(b);//放到缓存通道中
            } else if (msg.getCommandID() == SGIPCommend.SGIP_BIND_RESP) {

                BindResp br = (BindResp) getSGIPCommendDecode(msg);
                br.setResult(SGIPUtils.ByteArrayToInt2(br.getResultByte()));
                out.add(br);//放到缓存通道中
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ReferenceCountUtil.release(msg);
        }
    }

    /**
     * @param obj
     * @return 封装公有参数
     * @author dth
     */
    private SGIPCommend getSGIPCommendEncode(SGIPCommend obj) {
        obj.setNodeIdByte(SGIPUtils.IntToByteArray2(obj.getNodeId()));//第一部分序列号s
        obj.setCommandNodeIdDateByte(SGIPUtils.IntToByteArray2(obj.getCommandNodeIdDate()));//第二部分序列号
        obj.setCommandNumberByte(SGIPUtils.IntToByteArray2(obj.getCommandNumber()));//第三部分序列号

        return obj;
    }

    private SGIPCommend getSGIPCommendDecode(SGIPCommend obj) {
        obj.setNodeId(SGIPUtils.ByteArrayToInt2(obj.getNodeIdByte()));//第一部分序列号s
        obj.setCommandNodeIdDate(SGIPUtils.ByteArrayToInt2(obj.getCommandNodeIdDateByte()));//第二部分序列号
        obj.setCommandNumber(SGIPUtils.ByteArrayToInt2(obj.getCommandNumberByte()));//第三部分序列号

        return obj;
    }


}
