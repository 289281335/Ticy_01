package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.dao.alarm.IAlarmStudentDAO;
import com.sunmnet.bigdata.web.exception.PlatformException;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.entity.student.StudentConsumeDetail;
import com.sunmnet.bigdata.web.model.request.student.*;
import com.sunmnet.bigdata.web.service.alarm.IAlarmStudentService;
import com.sunmnet.bigdata.web.service.portrait.IPortraitStudentConsumeService;
import com.sunmnet.bigdata.web.service.student.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 用户画像
 */


@Controller
@RequestMapping("portrait")
public class PortraitController extends BaseController {


    @Autowired
    IStudentInfoService studentInfoService;
    @Autowired
    IAlarmStudentService alarmStudentService;
    @Autowired
    IStudentScoresService studentScoresService;
    @Autowired
    IPortraitStudentConsumeService portraitStudentConsumeService;
    @Autowired
    IStudentBookBorrowService studentBookBorrowService;
    @Autowired
    IStudentNetTimeInfoService studentNetTimeInfoService;
    @Autowired
    IStudentConsumeDetailService studentConsumeDetailService;
    @Autowired
    IConsumeAnalysisService consumeAnalysisService;

    @ApiOperation(value = "学生群体画像查询")
    @ResponseBody
    @RequestMapping(value = "/studentsInfo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生信息请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("学生群体画像查询")
    public JsonResult studentsInfo(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(studentInfoService.studentsInfo(studentInfoREQ));
    }

    @ApiOperation(value = "分析不同维度的学生人数")
    @ResponseBody
    @RequestMapping(value = "/countStudentByCategory", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生信息请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("分析不同维度的学生人数")
    public JsonResult countStudentByCategory(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(studentInfoService.countStudentByCategory(studentInfoREQ));
    }

    @ApiOperation(value = "当前贫困生分析|平困生|虚假平困生|关爱数")
    @ResponseBody
    @RequestMapping(value = "/countPoverty", method = {RequestMethod.POST})
    @AccessLogger("当前贫困生分析")
    public JsonResult countPoverty() {
        Map map=new HashMap();
        map.put("povertyStudent",portraitStudentConsumeService.povertyStudent());
        map.put("unPovertyStudent",portraitStudentConsumeService.unPovertyStudent());
        map.put("supportPovertyStudent",portraitStudentConsumeService.supportPovertyStudent());
        return buildSuccJson(map);
    }


    @ApiOperation(value = "分页查询异常贫困学生列表")
    @ResponseBody
    @RequestMapping(value = "/pageUnusualPovertyStudent", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentPovertyAnalyseREQ",value = "分页查询异常贫困学生|根据需要传入分页参数和查询条件",
                    required = true, paramType = "body", dataType = "PageStudentPovertyAnalyseREQ")
    })
    @AccessLogger("分页查询异常贫困学生列表")
    public JsonResult pageUnusualPovertyStudent(@RequestBody PageStudentPovertyAnalyseREQ pageStudentPovertyAnalyseREQ ){
        return buildSuccJson(portraitStudentConsumeService.pageUnusualPovertyStudent(pageStudentPovertyAnalyseREQ));
    }


    @ApiOperation(value = "更改异常贫困学生关注状态")
    @ResponseBody
    @RequestMapping(value = "/updateUnusualPovertyStudentFocusStatus", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentPovertyAnalyseREQ",value = "贫困生分析表请求对象|根据需要传入参数和条件",
                    required = true, paramType = "body", dataType = "StudentPovertyAnalyseREQ")
    })
    @AccessLogger("更改异常贫困学生关注状态")
    public JsonResult updateUnusualPovertyStudentFocusStatus(@RequestBody StudentPovertyAnalyseREQ studentPovertyAnalyseREQ) {
        return buildSuccJson(portraitStudentConsumeService.updatePovertyStudentFocusStatus(studentPovertyAnalyseREQ));
    }

    @ApiOperation(value = "查询关爱学生列表")
    @ResponseBody
    @RequestMapping(value = "/pageStudentPovertySupport", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentPovertySupportREQ",value = "查询关爱学生列表|根据需要传入分页参数和查询条件|student_poverty_support",
                    required = true, paramType = "body", dataType = "PageStudentPovertySupportREQ")
    })
    @AccessLogger("查询关爱学生列表")
    public JsonResult pagePovertyPovertyStudent(@RequestBody PageStudentPovertySupportREQ pageStudentPovertySupportREQ ){
        return buildSuccJson(portraitStudentConsumeService.pageStudentPovertySupport(pageStudentPovertySupportREQ));
    }


    @ApiOperation(value = "根据性别和学位统计学生结构")
    @ResponseBody
    @RequestMapping(value = "/countStructureByDegreeAndGender", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生信息请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据性别和学位统计学生结构")
    public JsonResult countStructureByDegreeAndGender(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(studentInfoService.countStructureByDegreeAndGender(studentInfoREQ));
    }

    @ApiOperation(value = "根据学位和生源地统计学生分布")
    @ResponseBody
    @RequestMapping(value = "/countStructureByDegreeAndNativePlace", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生信息请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据学位和生源地统计学生分布")
    public JsonResult countStructureByDegreeAndNativePlace(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(studentInfoService.countStructureByDegreeAndNativePlace(studentInfoREQ));
    }
    @ApiOperation(value = "最近个六月图书借阅次数")
    @ResponseBody
    @RequestMapping(value = "/countBookBorrowByLatestSixMonth", method = {RequestMethod.POST})
    @AccessLogger("最近六个月图书借阅次数")
    public JsonResult countStructureByDegreeAndNativePlace() {
        return buildSuccJson(studentBookBorrowService.countBookBorrowByLatestSixMonth());
    }
    @ApiOperation(value = "图书借阅频次排名（学院、专业）前五")
    @ResponseBody
    @RequestMapping(value = "/countBookBorrowByCollegeCode", method = {RequestMethod.POST})
    @AccessLogger("图书借阅频次排名（学院、专业）前五")
    public JsonResult countBookBorrowByCollegeCode() {
        return buildSuccJson(studentBookBorrowService.countBookBorrowByCollegeCode());
    }
    //学生成绩分布
    @ApiOperation(value = "学生成绩分布|总人数|count0~4阶段绩点分数的人数")
    @ResponseBody
    @RequestMapping(value = "/countStudentScore", method = {RequestMethod.POST})
    @AccessLogger("学生成绩分布")
    public JsonResult countStudentScore() {
        return buildSuccJson(studentScoresService.countStudentScore());
    }
    //上网平均时段分布
    @ApiOperation(value = "上网平均时段分布")
    @ApiImplicitParams({
            @ApiImplicitParam(name="collegeCode",value="学院代码",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="majorCode",value="专业代码",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="className",value="班级",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="nation",value="民族",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="gender",value="性别",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="studentPlace",value="生源地",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="schoolTerm",value="学期",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="academyName",value="书院",required = false,paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/countSurfInternetByParagraph", method = {RequestMethod.POST})
    @AccessLogger("上网平均时段分布")
    public JsonResult countSurfInternetByParagraph( @RequestParam(value = "collegeCode",required = false) String collegeCode,
                                                    @RequestParam(value = "majorCode",required = false) String majorCode,  @RequestParam(value = "className",required = false) String className,
                                                    @RequestParam(value = "nation",required = false) String nation,  @RequestParam(value = "gender",required = false) String gender,
                                                    @RequestParam(value = "studentPlace",required = false) String studentPlace,  @RequestParam(value = "schoolTerm",required = false) String schoolTerm,
                                                    @RequestParam(value = "academyName",required = false) String academyName) {
        return buildSuccJson(studentNetTimeInfoService.netTimeSlotAnalyse(collegeCode,  majorCode,  className,  nation, gender,  studentPlace,  schoolTerm,  academyName));
    }
    //上网平均时长分布
    @ApiOperation(value = "上网平均时长分布")
    @ApiImplicitParams({
            @ApiImplicitParam(name="collegeCode",value="学院代码",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="majorCode",value="专业代码",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="className",value="班级",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="nation",value="民族",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="gender",value="性别",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="studentPlace",value="生源地",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="schoolTerm",value="学期",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="academyName",value="书院",required = false,paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/countSurfInternetByDuration", method = {RequestMethod.POST})
    @AccessLogger("上网平均时长分布")
    public JsonResult countSurfInternetByDuration( @RequestParam(value = "collegeCode",required = false) String collegeCode,
                                                    @RequestParam(value = "majorCode",required = false) String majorCode,  @RequestParam(value = "className",required = false) String className,
                                                    @RequestParam(value = "nation",required = false) String nation,  @RequestParam(value = "gender",required = false) String gender,
                                                    @RequestParam(value = "studentPlace",required = false) String studentPlace,  @RequestParam(value = "schoolTerm",required = false) String schoolTerm,
                                                    @RequestParam(value = "academyName",required = false) String academyName) {
        return buildSuccJson(studentNetTimeInfoService.netTimeAnalyse(collegeCode,  majorCode,  className,  nation, gender,  studentPlace,  schoolTerm,  academyName));
    }
    //一卡通消费趋势分析
    @ApiOperation(value = "综合画像 一卡通消费趋势分析")
    @ApiImplicitParams({
            @ApiImplicitParam(name="consumeTime",value="时间",required = true,paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/countConsumeTrend", method = {RequestMethod.POST})
    @AccessLogger("综合画像 一卡通消费趋势分析")
    public JsonResult countConsumeTrend(@RequestParam(value = "gender",required=false) String gender,  @RequestParam(value = "consumeTime") String consumeTime) {
        return buildSuccJson(studentConsumeDetailService.countConsumeTrend(gender,  consumeTime));
    }
    //三餐就餐率
    @ApiOperation(value = "综合画像 三餐就餐率")
    @ApiImplicitParams({
            @ApiImplicitParam(name="schoolYear",value="学年",required = true,paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/countThreeMealsTrend", method = {RequestMethod.POST})
    @AccessLogger("综合画像 三餐就餐率")
    public JsonResult countThreeMealsTrend(@RequestParam(value = "schoolYear") String schoolYear) {
        WholePortraitREQ wp=new WholePortraitREQ();
        wp.setSchoolYear(schoolYear);
        return buildSuccJson(consumeAnalysisService.getWholeDietRate(wp));
    }
    //热门窗口排名
    @ApiOperation(value = "综合画像 热门窗口排名")
    @ApiImplicitParams({
            @ApiImplicitParam(name="schoolYear",value="学年",required = true,paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value = "/countConsumerPlaceTrend", method = {RequestMethod.POST})
    @AccessLogger("综合画像 热门窗口排名")
    public JsonResult countConsumerPlaceTrend(@RequestParam(value = "schoolYear") String schoolYear) {
        WholePortraitREQ wp=new WholePortraitREQ();
        wp.setSchoolYear(schoolYear);
        return buildSuccJson(consumeAnalysisService.getWholeDietPlace(wp));
    }
    //待处理预警统计
    @ApiOperation(value = "综合画像 待处理预警统计")
    @ResponseBody
    @RequestMapping(value = "/countUndisposedAlarm", method = {RequestMethod.POST})
    @AccessLogger("综合画像 待处理预警统计")
    public JsonResult countConsumerPlaceTrend() {
        return buildSuccJson(alarmStudentService.countUndisposedAlarm());
    }
    //就业率趋势分析

    /*****************************************************************/
    /*****************************************************************/
    /*****************************************************************/
    /*****************************************************************/
//    /**
//     * 助学金获取人数趋势查询
//     * @return
//     */
//    @RequestMapping(value="/supportCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object querySupportCount() {
//        return buildSuccJson(portraitStudentConsumeService.querySupportCountForYear());
//    }
//
//    /**
//     * 贫困生学院分布查询
//     * @return
//     */
//    @RequestMapping(value="/collegeCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryCollegeCount() {
//        List<SupportCollegeCountDTO> list = needyStudentAnalysisService.querySupportCollegeCount();
//        Map<String, List<SupportCollegeCountDTO>> map = new HashMap<String, List<SupportCollegeCountDTO>>();
//        map.put("list", list);
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生性别分布查询
//     * @return
//     */
//    @RequestMapping(value="/genderCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryGenderCount() {
//        Map<String, Long> map = needyStudentAnalysisService.queryGenderCount();
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生生源地分布查询
//     * @return
//     */
//    @RequestMapping(value="/placeCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryPlaceCount() {
//        List<Map<String, Object>> list = needyStudentAnalysisService.queryPlaceCount();
//        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
//        map.put("list", list);
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生民族分布查询
//     * @return
//     */
//    @RequestMapping(value="/nationCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryNationCount() {
//        List<Map<String, Object>> list = needyStudentAnalysisService.queryNationCount();
//        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
//        map.put("list", list);
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生和非贫困生月消费数据
//     * @param studentNumber
//     * @return
//     */
//    @RequestMapping(value="/consumeAmount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryNeedyAndGeneralConsumeData() {
//        Map<String, Object> map = consumeAnalysisService.queryNeedyAndGeneralStudentConsumeData();
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生和非贫困生人均每日三餐消费金额对比查询
//     * @return
//     */
//    @RequestMapping(value="/eatAmount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryNeedyAndGeneralDietConsumeAmount() {
//        Map<String, Object> map = consumeAnalysisService.queryNeedyAndGeneralDietDayConsumeAmount();
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 贫困生和非贫困生人均每月三餐次数对比查询
//     * @return
//     */
//    @RequestMapping(value="/eatCount",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryNeedyAndGeneralDietConsumeCount() {
//        Map<String, Object> map = consumeAnalysisService.queryNeedyAndGeneralDietMonthConsumeCount();
//        return buildSuccJson(map);
//    }
//
//    /**
//     * 查询消费稳定性
//     * @return
//     */
//    @RequestMapping(value="/consumeStability",method= RequestMethod.POST)
//    @ResponseBody
//    public Object queryConsumeStability() {
//        Map<String, Object> map = needyStudentAnalysisService.queryConsumeStability();
//        return buildSuccJson(map);
//    }



}
