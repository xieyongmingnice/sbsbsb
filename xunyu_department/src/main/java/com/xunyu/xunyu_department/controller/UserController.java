package com.xunyu.xunyu_department.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.commons.core.util.MD5Utils;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.department.UsersModel;
import com.xunyu.xunyu_department.pojo.Users;
import com.xunyu.xunyu_department.service.UserService;
import com.xunyu.xunyu_department.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xym
 * @description
 * @date 2018/4/25 16:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String success = "SUCCESS";

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 新增员工
     * @param model
     * @return
     */
    @RequestMapping(value = "/addemployee",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addEmployee(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            List<Users> users = userService.selectUserListByAccount(model);
            if (users != null && users.size()>0){
                result.setMessage("用户名已存在，请重新输入用户名");
                result.setCode(ResultMessage.Code.USER_EXIST);
                return result;
            }
            model.setPassword(MD5Utils.getMD5(model.getPassword()));
            int count = userService.addUser(model);
            if (count > 0){
                operationSuccess(result);
                result.setRes(success);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 修改员工信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/editemployeeinfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> editEmployeeInfo(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            if (model.getPassword() != null){
                model.setPassword(MD5Utils.getMD5(model.getPassword()));
            }
            int count = userService.updateUserInfo(model);
            if (count>0){
                operationSuccess(result);
                result.setRes(success);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 删除员工
     * @param model
     * @return
     */
    @RequestMapping(value = "/delemployee",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteEmployee(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            int success = userService.deleteUser(model);
            if (success>0){
                operationSuccess(result);
                result.setRes(success);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 获得员工信息列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/getemployeelist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<UsersVO>> getEmployeeList(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        int currPage = model.getCurrPage();
        if (currPage == 0){
            result.setMessage(ResultMessage.Message.PRAMA_LOSS);
            result.setCode(ResultMessage.Code.PRAMA_LOSS);
            return result;
        }
        model.setOffset(model.getStartRows());
        try {
            Integer totalRows = userService.selectTotalRows(model);
            List<UsersVO> list = userService.selectUserList(model);
            if (list != null && list.size()>0) {
                operationSuccess(result);
                result.setRes(list);
                result.setTotalRows(totalRows == null?0:totalRows);
            }else {
                result.setMessage(ResultMessage.Message.NO_VALUE);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 批量删除员工信息
     * @return
     */
    @RequestMapping(value = "/batchdelemployee",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteEmployee(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        List<Long> list = model.getIdList();
        try{
            int count = userService.batchDeleteUser(list);
            if(list !=null && count == list.size()){
                operationSuccess(result);
                result.setRes(success);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 查询单个员工信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<Users> getUserInfo(UsersModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            Users users = userService.selectByPrimaryKey(model);
            if(users !=null){
                operationSuccess(result);
                result.setRes(users);
            }else {
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.NO_VALUE);
            }
        }catch (Exception e){
            catchExcpetion(e,result);
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
    }

}
