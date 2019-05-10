package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.service.statics.IReportService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计类控制器
 */
@RestController
@RequestMapping(value = "/report")
public class ReportController extends  BaseController{


//    @ApiOperation(value = "学业预警历史预警趋势")
//    @ResponseBody
//    @RequestMapping(value = "/historyTruancy", method = {RequestMethod.POST})
//    @AccessLogger("学业预警历史预警趋势")
//    public JsonResult historyTruancy() {
//        return buildSuccJson(alarmStudentTruancyService.historyTruancy());
//    }
    @Autowired
    IReportService reportService;
    /**
     * 按月查询预警数量趋势
     * @return
     */
    @ApiOperation(value="按月查询预警数量趋势")
    @RequestMapping(value="/countAlarmByMonth",method = {RequestMethod.POST})
    @ResponseBody
//    @ApiImplicitParams({@ApiImplicitParam(name="code",value="字典代码code",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("按月查询预警数量趋势")
    public JsonResult countAlarmByMonth() {
        return buildSuccJson(reportService.countAlarmByMonth());
    }


    /**
     * 查询预警数量学院排名
     * @return
     */
    @ApiOperation(value="查询预警数量学院排名")
    @RequestMapping(value="/queryAlarmCollegeRank",method = {RequestMethod.POST})
    @ResponseBody
    @AccessLogger("查询预警数量学院排名")
    public JsonResult queryAlarmCollegeRank() {
        return buildSuccJson(reportService.queryAlarmCollegeRank());
    }

    /**
     * 查询预警处理效率学院排名
     * @return
     */
    @ApiOperation(value="查询预警处理效率学院排名")
    @RequestMapping(value="/queryAlarmDealRank",method = {RequestMethod.POST})
    @ResponseBody
    @AccessLogger("查询预警处理效率学院排名")
    public JsonResult queryAlarmDealRank() {
        return buildSuccJson(reportService.queryAlarmDealRank());
    }

    /**
     * 查询预警准确率
     * @return
     */
    @ApiOperation(value="查询预警准确率")
    @RequestMapping(value="/queryAlarmAccuracyRate",method = {RequestMethod.POST})
    @ResponseBody
    @AccessLogger("查询预警准确率")
    public JsonResult queryAlarmAccuracyRate() {
        return buildSuccJson(reportService.queryAlarmAccuracyRate());
    }



//    /**
//     * 读研类学校信息查询
//     * @return
//     */
//    @RequestMapping(value="/getAll")
//    @ResponseBody
//    public Object getAll(){
//        try {
//            List<ReadSchoolDTO> list = readSchoolInfoService.getAll();
//            Map<String, List<ReadSchoolDTO>> map = new HashMap<String, List<ReadSchoolDTO>>();
//            map.put("list", list);
//            return buildSuccJson(map);
//        } catch (Exception e) {
//            logger.error("读研类学校信息查询异常",e);
//            return buildErrJson("标签查询失败");
//        }
//
//
//    }
}
