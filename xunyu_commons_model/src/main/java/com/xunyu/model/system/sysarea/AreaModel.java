package com.xunyu.model.system.sysarea;

import com.xunyu.model.user.UserModel;

/**
 * @author dth
 * @date 2018/5/8 10:26
 **/
public class AreaModel extends UserModel {

    private String country;//国家
    private String provinces;//省
    private String city;//市


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }
}
