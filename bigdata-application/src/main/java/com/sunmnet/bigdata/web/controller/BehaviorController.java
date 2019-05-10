package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.entity.behavior.BehaviorGroupLabel;
import com.sunmnet.bigdata.web.model.request.behavior.BehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.PageBehaviorStudentLabelREQ;
import com.sunmnet.bigdata.web.model.request.behavior.PageStudentTracesREQ;
import com.sunmnet.bigdata.web.service.behavior.IBehaviorStudentTracesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/behavior/traces")
public class BehaviorController extends BaseController {

    @Resource
    private IBehaviorStudentTracesService behaviorStudentTracesService;


    @ApiOperation(value = "分页查询一卡通打卡记录")
    @ResponseBody
    @RequestMapping(value = "/pageTracesDetail", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentInfoREQ",value = "学生一卡通请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentTracesREQ")
    })
    @AccessLogger("分页查询一卡通打卡记录")
    public JsonResult pageTracesDetail(@RequestBody PageStudentTracesREQ pageStudentInfoREQ) {
        return buildSuccJson(behaviorStudentTracesService.pageTracesDetail(pageStudentInfoREQ));
    }


    /********************************************人群行为轨迹*****************************************
     * **********************************************************************************************
     * **********************************************************************************************
     * **********************************************************************************************
     */

    @Resource
    private IBehaviorStudentTracesService iBehaviorStudentTracesService;

    @ApiOperation(value = "人群行为轨迹查询")
    @ResponseBody
    @RequestMapping(value = "/behaviorTrack",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "behaviorStudentLabelREQ",value = "学生群体标签请求实体类|根据需要传入查询条件",
            required = true,paramType = "body",dataType = "BehaviorStudentLabelREQ")
    })
    @AccessLogger("人群行为轨迹查询")
    public  JsonResult behaviorTrack(@RequestBody BehaviorStudentLabelREQ behaviorStudentLabelREQ){
            return buildSuccJson(iBehaviorStudentTracesService.listBehaviorTrack(behaviorStudentLabelREQ));
    }

    @ApiOperation(value = "重点人群管理--根据条件查询学生信息列表")
    @ResponseBody
    @RequestMapping(value = "/pageStudentInfoByCondition",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageBehaviorStudentLabelREQ",value = "学生群体标签请求分页实体类|根据需要传入查询条件",
                    required = true,paramType = "body",dataType = "PageBehaviorStudentLabelREQ")
    })
    @AccessLogger("重点人群管理--根据条件查询学生信息列表")
    public  JsonResult pageStudentInfoByCondition(@RequestBody PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ){
            return buildSuccJson(iBehaviorStudentTracesService.pageStudentInfoByCondition(pageBehaviorStudentLabelREQ));
    }

    @ApiOperation(value = "重点人群管理--查询群体标签列表")
    @ResponseBody
    @RequestMapping(value = "/listGroupLabel",method = {RequestMethod.POST})
    @AccessLogger("重点人群管理--查询群体标签列表")
    public  JsonResult listGroupLabel(){
        return buildSuccJson(iBehaviorStudentTracesService.listGroupLabel());
    }

    @ApiOperation(value = "重点人群管理--根据标签查询学生列表")
    @ResponseBody
    @RequestMapping(value = "/pageStudentInfoByLabel",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageBehaviorStudentLabelREQ",value = "学生群体标签请求实体类|需要传入标签名",
                    required = true,paramType = "body",dataType = "PageBehaviorStudentLabelREQ")
    })
    @AccessLogger("重点人群管理--根据标签查询学生列表")
    public  JsonResult pageStudentInfoByLabel(@RequestBody PageBehaviorStudentLabelREQ pageBehaviorStudentLabelREQ){
            return buildSuccJson(iBehaviorStudentTracesService.pageStudentInfoByLabel(pageBehaviorStudentLabelREQ));
    }

    @ApiOperation(value = "重点人群管理--根据标签查询标签信息")
    @ResponseBody
    @RequestMapping(value = "/getLabelInfoByLabel",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "labelName",value = "需要传入标签名",
                    required = false,paramType = "query")
    })
    @AccessLogger("重点人群管理--根据标签查询学生列表")
    public  JsonResult getLabelInfoByLabel(@RequestBody(required = false) String labelName){
        return buildSuccJson(iBehaviorStudentTracesService.getLabelInfoByLabel(labelName));
    }

    @ApiOperation(value = "重点人群管理--创建新群体标签并添加学生")
    @ResponseBody
    @RequestMapping(value = "/saveGroupLabelAndStudent",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "behaviorGroupLabel",value = "群体标签实体类|需要传入标签名和标签描述",
                    required = true,paramType = "body",dataType = "BehaviorGroupLabel"),
            @ApiImplicitParam(name = "studentNos",value = "学号集字符串|字符串格式为studentNo+','+studentNo",
                    required = true,paramType = "query")
    })
    @AccessLogger("重点人群管理--学生添加到新建群体标签中")
    public  JsonResult saveGroupLabelAndStudent(@RequestBody BehaviorGroupLabel behaviorGroupLabel,@RequestParam  String studentNos){
        List<String> list = Arrays.asList(studentNos.split(","));
        iBehaviorStudentTracesService.saveGroupLabelAndStudent(behaviorGroupLabel, list);
        return buildSuccJson();
    }

    @ApiOperation(value = "重点人群管理--修改群体标签和学生")
    @ResponseBody
    @RequestMapping(value = "/updateGroupLabelAndStudent",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "behaviorGroupLabel",value = "群体标签实体类|需要传入标签名和标签描述",
                    required = true,paramType = "body",dataType = "BehaviorGroupLabel"),
            @ApiImplicitParam(name = "studentNos",value = "学号集字符串|字符串格式为studentNo+','+studentNo",
                    required = true,paramType = "query")
    })
    @AccessLogger("重点人群管理--学生添加到新建群体标签中")
    public  JsonResult updateGroupLabelAndStudent(@RequestBody BehaviorGroupLabel behaviorGroupLabel,@RequestParam String studentNos){
        List<String> list = Arrays.asList(studentNos.split(","));
        iBehaviorStudentTracesService.updateGroupLabelAndStudent(behaviorGroupLabel, list);
        return buildSuccJson();
    }

    @ApiOperation(value = "重点人群管理--删除标签")
    @ResponseBody
    @RequestMapping(value = "/deleteGroupLabel",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "behaviorStudentLabelREQ",value = "学生群体标签请求实体类|需要传入标签名",
                    required = true,paramType = "body",dataType = "BehaviorStudentLabelREQ")
    })
    @AccessLogger("重点人群管理--删除标签")
    public  JsonResult deleteGroupLabel(@RequestBody BehaviorStudentLabelREQ behaviorStudentLabelREQ){
            iBehaviorStudentTracesService.deleteGroupLabel(behaviorStudentLabelREQ);
            return buildSuccJson();
    }

    /********************************************上网轨迹*********************************************
     * **********************************************************************************************
     * **********************************************************************************************
     * **********************************************************************************************
     */
//    @ApiOperation(value = "上网轨迹的网络行为管理")
//    @ResponseBody
//    @RequestMapping(value = "/behaviorTrackPeople",method = {RequestMethod.POST})
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "",value = "",
//                    required = true,paramType = "",dataType = "")
//    })
//    @AccessLogger("上网轨迹的网络行为管理")
//    public  JsonResult surfTrackBehavior(){
//
//    }
//
//
//    @ApiOperation(value = "监测网站信息列表分页查询")
//    @ResponseBody
//    @RequestMapping(value = "/pageWebInfo",method = {RequestMethod.POST})
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "",value = "",
//                    required = true,paramType = "",dataType = "")
//    })
//    @AccessLogger("监测网站信息列表分页查询")
//    public  JsonResult pageWebInfo(){
//
//    }
//
//    @ApiOperation(value = "新增配置修改监测网站信息")
//    @ResponseBody
//    @RequestMapping(value = "/updateWebInfo",method = {RequestMethod.POST})
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "",value = "",
//                    required = true,paramType = "",dataType = "")
//    })
//    @AccessLogger("新增配置修改监测网站信息")
//    public  JsonResult updateWebInfo(){
//
//        }

}
