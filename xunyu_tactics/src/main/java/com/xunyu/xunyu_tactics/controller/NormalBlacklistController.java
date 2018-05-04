package com.xunyu.xunyu_tactics.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.tactics.NormalBlacklistModel;
import com.xunyu.xunyu_tactics.constant.TacticsConstants;
import com.xunyu.xunyu_tactics.pojo.NormalBlacklist;
import com.xunyu.xunyu_tactics.service.ExcelService;
import com.xunyu.xunyu_tactics.service.NormalBlacklistService;
import com.xunyu.xunyu_tactics.vo.NormalBlacklistVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xym
 * @description 普通黑名单控制器
 * @date 2018/5/4 16:54
 */
@RestController
@RequestMapping("/blacklist")
public class NormalBlacklistController {

    private static final Logger logger = LoggerFactory.getLogger(NormalBlacklistController.class);

    private static final String SUCCESS = "SUCCESS";

    private static final String FAILED = "FAILED";

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ExcelService excelService;

    @Autowired
    NormalBlacklistService blacklistService;

    /**
     * 新增
     */
    @RequestMapping(value = "/addblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addBlacklist(NormalBlacklistModel model) throws Exception{
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        model.setBlacklistSource(TacticsConstants.RedlistSource.MANUAL_ADD);
        model.setRemarks("手动添加");
        int success = blacklistService.addBlacklist(model);
        if (success>0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/deleteblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        int success = blacklistService.deleteBlacklist(model);
        if (success>0){
            operationSuccess(result);
        }else {
            operationFailed(result);
        }
        return result;
    }
    /**
     * 查询列表
     */
    @RequestMapping(value = "/getblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<NormalBlacklistVO>> getBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        int currPage = model.getCurrPage();
        if (currPage == 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        model.setOffset(model.getStartRows());
        int totalRows = blacklistService.selectTotalRows(model);
        if (totalRows <= 0){
            result.setCode(ResultMessage.Code.SUCCESS);
            result.setMessage(ResultMessage.Message.NO_VALUE);
            result.setRes(SUCCESS);
            return result;
        }
        List<NormalBlacklistVO> list = blacklistService.selectBlacklist(model);
        if (list != null && list.size() > 0){
            operationSuccess(result);
            result.setRes(list);
            result.setTotalRows(totalRows);
        }
        return result;
    }
    /**
     * 批量删除
     */
    @RequestMapping(value = "/batchdeleteblacklist",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteBlacklist(NormalBlacklistModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getMessage() != null){
            return result;
        }
        return result;
    }

    /**
     * 导入excel 新增
     */
    @RequestMapping(value = "/exceladdblacklist",method = RequestMethod.POST)
    public Result<String> excelAddBlacklist(HttpServletRequest request,String sessionId){
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        return result;
    }
    /**
     * 导入excel 删除
     */
    @RequestMapping(value = "/exceldelblacklist",method = RequestMethod.POST)
    public Result<String> excelDeleteBlacklist(HttpServletRequest request,String sessionId){
        Result result = checkLogin(new Result(),sessionId);
        if (result.getMessage() != null){
            return result;
        }
        return result;
    }

    private Result checkLogin(Result r, String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }

    private void catchExcpetion(Exception e,Result result){
        result.setCode(ResultMessage.Code.ERROR);
        result.setMessage(ResultMessage.Message.ERROR);
        logger.info("系统异常");
        e.printStackTrace();
    }

    private void operationSuccess(Result result){
        result.setCode(ResultMessage.Code.SUCCESS);
        result.setMessage(ResultMessage.Message.SUCCESS);
        result.setRes(SUCCESS);
    }

    private void operationFailed(Result result){
        result.setCode(ResultMessage.Code.FAILED);
        result.setMessage(ResultMessage.Message.FAILED);
        result.setRes(FAILED);
    }
}
