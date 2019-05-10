package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.request.alarm.AlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmLateBackAndLostREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmStudentREQ;
import com.sunmnet.bigdata.web.model.request.alarm.PageAlarmTruancySubjectsREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentRestREQ;
import com.sunmnet.bigdata.web.service.alarm.IAlarmLateBackService;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentService;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentSubjectsService;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentTruancyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

//@Api(value = "预警处理控制器API",tags = {"预警处理","查询统计预警相关"})
@RestController
@RequestMapping(value = "/alarm")
public class AlarmController extends BaseController {


    @Autowired
    IAlarmStudentSubjectsService alarmStudentSubjectsService;

    @ApiOperation(value = "统计学业预警数量")
    @ResponseBody
    @RequestMapping(value = "/subjects", method = {RequestMethod.POST})
    @AccessLogger("统计学业预警数量")
    public JsonResult subjects() {
        return buildSuccJson(alarmStudentSubjectsService.subjects());
    }

    @Autowired
    IAlarmStudentTruancyService alarmStudentTruancyService;

    @ApiOperation(value = "学业预警历史预警趋势")
    @ResponseBody
    @RequestMapping(value = "/historyTruancy", method = {RequestMethod.POST})
    @AccessLogger("学业预警历史预警趋势")
    public JsonResult historyTruancy() {
        return buildSuccJson(alarmStudentTruancyService.historyTruancy());
    }

    /*********************************************************************************/
    /**************************学生行为预警***********************/
    /*********************************************************************************/
    /*********************************************************************************/

    @Autowired
    IAlarmLateBackService alarmLateBackService;

    @ApiOperation(value = "学生迟归失联行为预警数量")
    @ResponseBody
    @RequestMapping(value = "/warningStudentCount", method = {RequestMethod.POST})
    @AccessLogger("学生迟归失联行为预警数量")
    public JsonResult queryStudentWarningCount() {
        return buildSuccJson(alarmLateBackService.listWarningStudent());
    }
    /**
     * 查询行为预警列表
     * @return
     */
    @ApiOperation(value = "查询迟归失联行为预警列表")
    @ResponseBody
    @RequestMapping(value = "/pageAlarmLateBackAndLostWarning", method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(name = "pageAlarmLateBackAndLostREQ",value = "失联迟归预警请求实体类",required = true, paramType = "body", dataType = "PageAlarmLateBackAndLostREQ")})
    @AccessLogger("查询迟归失联行为预警列表")
    public JsonResult pageAlarmLateBackAndLostWarning(@RequestBody PageAlarmLateBackAndLostREQ pageAlarmLateBackAndLostREQ) {

        return buildSuccJson(alarmLateBackService.listLateBackAndLostWarning(pageAlarmLateBackAndLostREQ));
    }

    /**
     * 查询行为预警每月数量
     * @return
     */
    @ApiOperation(value = "查询行为预警每月数量")
    @ResponseBody
    @RequestMapping(value = "/queryWarningMonthCount", method = {RequestMethod.POST})
    @AccessLogger("查询行为预警每月数量")
    public JsonResult queryWarningMonthCount() {
        return buildSuccJson(alarmLateBackService.listWarningMonthCount());
    }

    /**
     * 查询行为预警概要信息
     * @return
     */
    @ApiOperation(value="查询行为预警概要信息")
    @RequestMapping(value="/queryWarningGeneralInfo",method = {RequestMethod.POST})
    @ResponseBody
    @AccessLogger("查询行为预警概要信息")
    public JsonResult queryWarningGeneralInfo(){
        return buildSuccJson(alarmLateBackService.queryWarningGeneralInfo());
    }

    /**
     * 预警信息处理
     */
    @ApiOperation(value="预警信息处理")
    @RequestMapping(value="/updateWarningInfo",method = {RequestMethod.POST})
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="warningType",value="警告类型",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="warningDate",value="学号",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="reason",value="原由",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="remark",value="标记",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("预警信息处理")
    public JsonResult updateWarningInfo(
            @RequestParam(value = "studentNo") String studentNo,
            @RequestParam(value = "warningType") String warningType,
            @RequestParam(value = "warningDate") String warningDate,
            @RequestParam(value = "reason") String reason,
            @RequestParam(value = "remark") String remark) {
        alarmLateBackService.dealWarningInfo(studentNo, warningType, warningDate, reason, remark);
        return buildSuccJson();
    }



    /**
     * 挂科和逃课预警
     */
    @ApiOperation(value = "挂科和逃课预警")
    @RequestMapping(value="/pageTruancySubjectsWaring",method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name="pageAlarmTruancySubjectsREQ",value="挂科和逃课预警请求实体",required = true,paramType = "body",dataType ="PageAlarmTruancySubjectsREQ" )})
    @AccessLogger("挂科和逃课预警")
    public JsonResult pageTruancySubjectsWaring(@RequestBody PageAlarmTruancySubjectsREQ pageAlarmTruancySubjectsREQ) {
        return buildSuccJson(alarmStudentSubjectsService.pageTruancySubjectsWaring(pageAlarmTruancySubjectsREQ));
    }

    /*********************************************************************************/
    /**************************学生紧急预警***********************/
    /*********************************************************************************/
    /*********************************************************************************/

    /**
     * 学生紧急预警数量
     * @return
     */
    @ApiOperation(value = "学生紧急预警数量")
    @ResponseBody
    @RequestMapping(value = "/countEmerWarningStudent", method = {RequestMethod.POST})
    @AccessLogger("学生紧急预警数量")
    public JsonResult countEmerWarningStudent() {
        return buildSuccJson(alarmLateBackService.countEmerWarningStudent());
    }

    /**
     * 查询紧急预警列表
     * @return
     */

    @ApiOperation(value = "查询紧急预警列表")
    @ResponseBody
    @RequestMapping(value = "/pageEmerWarning", method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(name = "pageStudentInfoREQ",value = "请求实体类",required = true, paramType = "body", dataType = "PageStudentInfoREQ")})
    @AccessLogger("查询紧急预警列表")
    public JsonResult pageEmerWarning(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(alarmLateBackService.pageEmerWarning(pageStudentInfoREQ));
    }

    /**
     * 查询每日紧急预警前15的数量
     * @return
     */
    @ApiOperation(value = "查询每日紧急预警")
    @ResponseBody
    @RequestMapping(value = "/countEmerWarningDay", method = {RequestMethod.POST})
    @AccessLogger("查询每日紧急预警")
    public JsonResult countEmerWarningDay() {
        return buildSuccJson(alarmLateBackService.countEmerWarningDay());
    }

    /**
     * 查询紧急预警概要信息
     * @return
     */
    @ApiOperation(value="查询紧急预警概要信息")
    @RequestMapping(value="/queryEmerWarningGeneralInfo",method = {RequestMethod.POST})
    @ResponseBody
    @AccessLogger("查询紧急预警概要信息")
    public JsonResult queryEmerWarningGeneralInfo(){
        return buildSuccJson(alarmLateBackService.queryEmerWarningGeneralInfo());
    }




    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/


}
