package com.xunyu.xunyu_department.controller;

import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.usergroup.UserGroupModel;
import com.xunyu.xunyu_department.pojo.UserGroup;
import com.xunyu.xunyu_department.service.UserGroupService;
import com.xunyu.xunyu_department.service.UserService;
import com.xunyu.xunyu_department.vo.UserGroupVO;
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
 * @author 员工分组管理controller
 * @description
 * @date 2018/4/25 14:48
 */
@RestController
@RequestMapping("usergroup")
public class UserGroupController {

    @Autowired
    UserGroupService userGroupService;

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;


    private Logger logger = LoggerFactory.getLogger(UserGroupController.class);

    /**
     * 新增员工分组信息
     */
    @RequestMapping(value = "/addusergroup",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> addUserGroup(UserGroupModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            int success = userGroupService.addUserGroup(model);
            if (success>0){
                operationSuccess(result);
                result.setRes("SUCCESS");
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 查询员工分组列表
     */
    @RequestMapping(value = "/getusergrouplist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<UserGroupVO>> selectUserGroupList(UserGroupModel model){
                Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            List<UserGroupVO> list = userGroupService.selectUserGroupList(model);
            operationSuccess(result);
            if (list != null && list.size()>0) {
                result.setRes(list);
                result.setTotalRows(list.size());
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 删除员工分组
     */
    @RequestMapping(value = "/delusergroup",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteUserGroup(UserGroupModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            int success = userGroupService.deleteUserGroup(model);
            if (success>0){
                operationSuccess(result);
                result.setRes("SUCCESS");
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 批量删除员工分组
     */
    @RequestMapping(value = "/batchdelusergroup",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> bathchDeleteUserGroup(UserGroupModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        List<Long> list = model.getIdList();
        try{
            int count = userGroupService.batchDeleteUserGroup(list);
            if(list !=null && count == list.size()){
                operationSuccess(result);
                result.setRes("SUCCESS");
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }

    /**
     * 修改员工分组信息
     */
    @RequestMapping(value = "/editusergroup",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> updateUserGroup(UserGroupModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try {
            int success = userGroupService.updateUserGroupInfo(model);
            if (success>0){
                operationSuccess(result);
                result.setRes("SUCCESS");
            }
        }catch (Exception e){
            catchExcpetion(e,result);
        }
        return result;
    }
    /**
     * 查看员工列表
     */
    @RequestMapping(value = "/showemployees",method = RequestMethod.POST)
    @ResponseBody
    public Result<UsersVO> showEmployees(UserGroupModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            List<UsersVO> users = userService.selectUserListByUserGroupId(model);
            if (users != null && users.size() > 0){
                operationSuccess(result);
                result.setRes(users);
                result.setTotalRows(users.size());
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
