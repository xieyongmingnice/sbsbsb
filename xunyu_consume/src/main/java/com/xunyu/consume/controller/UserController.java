package com.xunyu.consume.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultTypeEnum;
import com.commons.core.util.StringUtils2;
import com.xunyu.consume.service.RPCService;
import com.xunyu.consume.service.UserInfoService;
import com.xunyu.entity.User;
import com.xunyu.entity.UserInfo;
import com.xunyu.model.user.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private RPCService rpcService;

    @GetMapping("/")
    public String test() {
        System.out.println("invoke test");
        return " self-diagnosis 启动成功";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public UserInfo getUserInfo(Long userId) {
        System.out.println("invoke test");
        UserInfo user = null;
        try {
            user = userInfoService.queryByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 获取用户集合
     */
    @RequestMapping(value = "/listUserInfo", method = RequestMethod.GET)
    public Result<List<UserInfo>> listUserInfoData(UserModel userModel) {
        Map<String, Object> map = new HashMap<String, Object>();
        Result<List<UserInfo>> res = new Result<List<UserInfo>>();
        long total = 0L;
        if (userModel != null) {
            try {
                map.put("startRow", userModel.getStartRows());
                map.put("endRow", userModel.getEndRows());
                total = userInfoService.countUserInfo(map);
                res.setTotal(total);
                if (total > 0) {
                    List<UserInfo> list = userInfoService.listUser(map);
                    res.setCode("200");
                    res.setMessage(ResultTypeEnum.SUCCESS.toString());
                    res.setRes(list);
                } else {
                    res.setCode("403");
                    res.setMessage(ResultTypeEnum.DATA_NOT_EXIST.toString());
                }
            } catch (Exception e) {
                res.setCode("500");
                res.setMessage(ResultTypeEnum.SYS_ERR.toString());
                e.printStackTrace();
            }
        }
        return res;
    }

    @RequestMapping(value = "addUserInfo", method = RequestMethod.GET)
    public Result<UserInfo> addUserInfoData(UserInfo info) {
        Result<UserInfo> res = new Result<UserInfo>();
        int i = (int) (Math.random() * 100) + 1;
        if (info != null) {
            if (StringUtils2.isEmpty(info.getName())) {
                info.setName("二狗子_" + (i) + "号~");
            }
            try {
                long n = userInfoService.insertUserInfo(info);
                if (n > 0) {
                    res.setRes(info);
                    res.setMessage(ResultTypeEnum.SUCCESS.toString());
                    res.setCode("200");
                }
            } catch (Exception e) {
                res.setMessage(ResultTypeEnum.SYS_ERR.toString());
                res.setCode("500");
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 删除用户
     *
     * @author dth
     * Create
     */
    @RequestMapping(value = "delUserInfoByIds", method = RequestMethod.GET)
    public Result<UserInfo> deleteUserInfoByIdsData(String ids) {
        Result<UserInfo> res = new Result<UserInfo>();
        List<Long> listIds = new ArrayList<Long>();
        if (StringUtils2.isNotEmpty(ids)) {
            String[] idsLon = ids.split(",");
            for (int i = 0; i < idsLon.length; i++) {
                if (StringUtils2.isNotEmpty(idsLon[i])) { //再一次判断字符串末尾是不是有逗号
                    listIds.add(Long.parseLong(idsLon[i]));
                } else {
                    continue;
                }
            }
            try {
                long n = userInfoService.deleteUserInfo(listIds);
                if (n > 0) {
                    res.setCode("200");
                    res.setMessage(ResultTypeEnum.SUCCESS.toString());
                }
            } catch (Exception e) {
                res.setCode("500");
                res.setMessage(ResultTypeEnum.SYS_ERR.toString());
                e.printStackTrace();
            }
        }
        return res;
    }


    /**
     * 调用其它服务获取数据
     */
    @RequestMapping(value = "listUserOther", method = RequestMethod.GET)
    public Result<List<User>> listUserOther(UserModel userModel) {

        Result<List<User>> res = new Result<List<User>>();
        try {
            res = rpcService.listUserOther(userModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
