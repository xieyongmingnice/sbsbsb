package com.xunyu.operator.service.out;

import com.xunyu.operator.pojo.out.CarrierAgree;

import java.util.List;

/**
 * @author xym
 * @description 运营商协议service
 * @date 2018/6/12 17:13
 */
public interface CarrierAgreeService {
    /**
     * 根据{运营商类型}查找协议
     * @param carrierType 运营商类型
     * @return 协议列表
     */
    List<CarrierAgree> selectCarrierAgree(Integer carrierType);
}
