package com.xunyu.xunyu_department.controller;


import com.commons.core.message.Result;
import com.commons.core.message.ResultMessage;
import com.google.common.collect.Maps;
import com.xunyu.config.redis.RedisUtil;
import com.xunyu.model.department.DepartmentModel;
import com.xunyu.xunyu_department.pojo.Department;
import com.xunyu.xunyu_department.pojo.Users;
import com.xunyu.xunyu_department.service.DepartmentService;
import com.xunyu.xunyu_department.service.UserService;
import com.xunyu.xunyu_department.vo.UsersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xym
 * @description 部门操作controller
 * @date 2018/4/20 18:19
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    protected Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 新增企业部门
     */
    @RequestMapping(value = "/adddepartment", method = RequestMethod.POST)
    @ResponseBody
    public Result<Department> addDepartment(DepartmentModel model) {
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        Department department = new Department();
        department.setDepartmentName(model.getDepartmentName());
        department.setDepartmentLinkman(model.getDepartmentLinkman());
        department.setDepartmentPhone(model.getDepartmentPhone());
        department.setRemark(model.getRemark());
        try {
            int addRes = departmentService.addDepartment(department);
            if (addRes>0){
                result.setRes(department);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.SUCCESS);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }


        return result;
    }
    /**
     * 查询部门list
     */
    @RequestMapping(value = "/selectlist",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Department>> selectDepartmentList(DepartmentModel model){
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
        Map map = Maps.newHashMap();
        map.put("model",model);
        try{
            Integer totalRows = departmentService.selectTotalRows(model);

            List<Department> departments = departmentService.selectDepartmentList(map);
            if (departments != null && departments.size() > 0){
                result.setRes(departments);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setTotalRows(totalRows == null ? 0 :totalRows);
            }else {
                result.setMessage(ResultMessage.Message.NO_VALUE);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改部门信息
     */
    @RequestMapping(value = "/editdepartment",method = RequestMethod.POST)
    @ResponseBody
    public Result<Department> updateDepartmentInfo(DepartmentModel model){

        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        Department department = new Department();
        department.setDepartmentId(model.getDepartmentId());
        department.setDepartmentName(model.getDepartmentName());
        department.setDepartmentLinkman(model.getDepartmentLinkman());
        department.setDepartmentPhone(model.getDepartmentPhone());
        department.setRemark(model.getRemark());
        try{
            int flag = departmentService.updateDepartmentInfo(department);
            if (flag>0){
                result.setRes(department);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setMessage(ResultMessage.Message.SUCCESS);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看部门员工
     */
    @RequestMapping(value = "/showemployees",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Users>> showEmployees(DepartmentModel model){

        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            List<UsersVO> users = userService.selectUserListByDepartmentId(model);
            if (users != null && users.size() > 0){
                result.setRes(users);
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setTotalRows(users.size());
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除部门
     */
    @RequestMapping(value ="/deldepartment",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteDepartment(DepartmentModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        Department department = new Department();
        department.setDepartmentId(model.getDepartmentId());
        try{
            int success = departmentService.deleteDepartment(department);
            if (success>0){
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setCode(ResultMessage.Code.SUCCESS);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 批量删除部门
     */
    @RequestMapping(value = "/batchdeldepartment",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> batchDeleteDepartment(DepartmentModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            List<Long> list = model.getIdList();
            int updateRes = departmentService.batchDeleteDepartment(list);
            if (list != null && updateRes == list.size()){
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setCode(ResultMessage.Code.SUCCESS);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 查询单个企业部门信息
     */
    @RequestMapping(value = "/getdepartmentinfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<Department> getDepartmentInfo(DepartmentModel model){
        Result result = checkLogin(new Result(),model.getSessionId());
        if (result.getCode() != null){
            return result;
        }
        try{
            Department department = departmentService.selectByPrimaryKey(model);
            if (department != null ){
                result.setMessage(ResultMessage.Message.SUCCESS);
                result.setCode(ResultMessage.Code.SUCCESS);
                result.setRes(department);
            }else {
                result.setMessage(ResultMessage.Code.SUCCESS);
                result.setCode(ResultMessage.Message.NO_VALUE);
            }
        }catch (Exception e){
            result.setCode(ResultMessage.Code.ERROR);
            result.setMessage(ResultMessage.Message.ERROR);
            logger.info("系统异常");
            e.printStackTrace();
        }
        return result;
    }



    private Result checkLogin(Result r,String sessionId){
        boolean flag = redisUtil.sessionStatus(sessionId);
        if (!flag) {
            r.setCode(ResultMessage.Code.NOT_FOUND);
            r.setMessage(ResultMessage.Message.UN_LOGIN);
        }
        return r;
    }
}
