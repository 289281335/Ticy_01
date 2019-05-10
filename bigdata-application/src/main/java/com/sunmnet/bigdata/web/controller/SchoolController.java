package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.entity.school.SchoolInfo;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.school.SchoolInfoREQ;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentService;
import com.sunmnet.bigdata.web.service.school.ISchoolInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/school")
public class SchoolController extends BaseController {

    @Resource
    private ISchoolInfoService schoolInfoService;

    @ApiOperation(value = "获取学院信息")
    @ResponseBody
    @RequestMapping(value = "/listCollege", method = {RequestMethod.POST,RequestMethod.GET})
    @AccessLogger("获取学院信息")
    public JsonResult listCollege(){
        return buildSuccJson(schoolInfoService.listAllCollege());
    }

    @ApiOperation(value = "通过学院编号获取专业信息")
    @ResponseBody
    @RequestMapping(value = "/listMajorByCollege", method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "schoolInfoREQ",value = "学校请求实体类|需要传入collegeCode",required = true, paramType = "body", dataType = "SchoolInfoREQ")
    })
    @AccessLogger("通过学院编号获取专业信息")
    public JsonResult listMajorByCollege(@RequestBody SchoolInfoREQ schoolInfoREQ){
        return buildSuccJson(schoolInfoService.listMajorByCollege(schoolInfoREQ.getCollegeCode()));
    }


    @ApiOperation(value = "获取所有专业信息")
    @ResponseBody
    @RequestMapping(value = "/listAllMajor", method = {RequestMethod.POST,RequestMethod.GET})
    @AccessLogger("获取所有专业信息")
    public JsonResult listAllMajor(){
        return buildSuccJson(schoolInfoService.listAllMajor());
    }


    @ApiOperation(value = "通过专业编号获取班级信息")
    @ResponseBody
    @RequestMapping(value = "/listClassByMajor", method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "schoolInfoREQ",value = "学校请求实体类|需要传入majorCode",required = true, paramType = "body", dataType = "SchoolInfoREQ")
    })
    @AccessLogger("通过专业编号获取班级信息")
    public JsonResult listClassByMajor(@RequestBody SchoolInfoREQ schoolInfoREQ){
        return buildSuccJson(schoolInfoService.listClassByMajor(schoolInfoREQ.getMajorCode()));
    }


}
