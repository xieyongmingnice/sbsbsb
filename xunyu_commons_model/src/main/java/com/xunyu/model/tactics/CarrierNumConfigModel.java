package com.xunyu.model.tactics;

import com.xunyu.model.user.UserModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author xym
 * @description 运营商号段配置参数类
 * @date 2018/6/25 18:08
 */
public class CarrierNumConfigModel extends UserModel implements Serializable {

    private static final long serialVersionUID = -964288819035154484L;

    private List<Integer> chinaMobileNums;

    private List<Integer> chinaUnicomNums;

    private List<Integer> chinaTelecomNums;

    public List<Integer> getChinaMobileNums() {
        return chinaMobileNums;
    }

    public void setChinaMobileNums(List<Integer> chinaMobileNums) {
        this.chinaMobileNums = chinaMobileNums;
    }

    public List<Integer> getChinaUnicomNums() {
        return chinaUnicomNums;
    }

    public void setChinaUnicomNums(List<Integer> chinaUnicomNums) {
        this.chinaUnicomNums = chinaUnicomNums;
    }

    public List<Integer> getChinaTelecomNums() {
        return chinaTelecomNums;
    }

    public void setChinaTelecomNums(List<Integer> chinaTelecomNums) {
        this.chinaTelecomNums = chinaTelecomNums;
    }
}
