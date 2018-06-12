package com.xunyu.operator.service.out;

import com.xunyu.operator.dao.out.CarrierAgreeDaoImpl;
import com.xunyu.operator.pojo.out.CarrierAgree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @date 2018/6/12 17:14
 */
@Service
public class CarrierAgreeServiceImpl implements CarrierAgreeService{

    @Autowired
    CarrierAgreeDaoImpl dao;

    @Override
    public List<CarrierAgree> selectCarrierAgree() {
        return dao.selectCarrierAgreeList();
    }
}
