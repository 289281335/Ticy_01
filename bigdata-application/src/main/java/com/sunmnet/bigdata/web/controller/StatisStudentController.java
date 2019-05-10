package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.exception.PlatformException;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.entity.student.StudentSupportInfo;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentCourseTimeREQ;
import com.sunmnet.bigdata.web.model.request.statis.StatisStudentSurfInternetMonthREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageStudentSupportREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentRestREQ;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentCourseService;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentCourseTimeService;
import com.sunmnet.bigdata.web.service.statics.IStatisStudentSurfInternetMonthService;
import com.sunmnet.bigdata.web.service.student.IStudentCourseService;
import com.sunmnet.bigdata.web.service.student.IStudentScoresService;
import com.sunmnet.bigdata.web.service.student.IStudentSupportInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StatisStudentController extends BaseController {

    @Autowired
    IStatisStudentCourseTimeService statisStudentCourseTimeService;
    @Autowired
    IStatisStudentCourseService statisStudentCourseService;
    @Autowired
    IStatisStudentSurfInternetMonthService statisStudentSurfInternetMonthService;

    @ApiOperation(value = "查询学生的平均上课准点率")
    @ResponseBody
    @RequestMapping(value = "/listCourseTimeByStudentNo", method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentCourseTimeREQ",value = "学生请求实体类|需要传入学生学号，可以选择时间段",
                    required = true, paramType = "body", dataType = "StatisStudentCourseTimeREQ")
    })
    @AccessLogger("查询学生的平均上课准点率")
    public JsonResult listCourseTimeByStudentNo(@RequestBody StatisStudentCourseTimeREQ statisStudentCourseTimeREQ) {
        return buildSuccJson(statisStudentCourseTimeService.listStatisCourseTimeByStudentNo(statisStudentCourseTimeREQ));
    }


    @ApiOperation(value = "获得个人画像-综合画像个人选项卡上网信息")
    @ResponseBody
    @RequestMapping(value = "/getStudentNetTag", method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentSurfInternetMonthREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StatisStudentSurfInternetMonthREQ")
    })
    @AccessLogger("获得个人画像-综合画像个人选项卡上网信息")
    public JsonResult getStudentNetTag(@RequestBody StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        return buildSuccJson(statisStudentSurfInternetMonthService.getStudentNetTag(statisStudentSurfInternetMonthREQ.getStudentNo()));
    }

    @ApiOperation(value = "获得综合画像近7周上网时长的分析")
    @ResponseBody
    @RequestMapping(value = "/getNetTimeByStudentNo", method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentSurfInternetMonthREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StatisStudentSurfInternetMonthREQ")
    })
    @AccessLogger("获得个人画像-综合画像个人选项卡上网信息")
    public JsonResult getNetTimeByStudentNo(@RequestBody StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        return buildSuccJson(statisStudentSurfInternetMonthService.last7WeekSurfInternet(statisStudentSurfInternetMonthREQ.getStudentNo()));
    }


    @ApiOperation(value = "群体画像-上网时长分析")
    @ResponseBody
    @RequestMapping(value = "/analyseNetTime", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentSurfInternetMonthREQ",value = "学生请求实体类",
                    required = true, paramType = "body", dataType = "StatisStudentSurfInternetMonthREQ")
    })
    @AccessLogger("群体画像-上网时长分析")
    public JsonResult analyseNetTime(@RequestBody StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        return buildSuccJson(statisStudentSurfInternetMonthService.analyseNetTime(statisStudentSurfInternetMonthREQ));
    }


    @ApiOperation(value = "群体画像-上网时间段分析")
    @ResponseBody
    @RequestMapping(value = "/analyseNetSlot", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentSurfInternetMonthREQ",value = "学生请求实体类",
                    required = true, paramType = "body", dataType = "StatisStudentSurfInternetMonthREQ")
    })
    @AccessLogger("群体画像-上网时间段分析")
    public JsonResult analyseNetSlot(@RequestBody StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        return buildSuccJson(statisStudentSurfInternetMonthService.analysePeriodOfMonthNet(statisStudentSurfInternetMonthREQ));
    }


    @ApiOperation(value = "学生上网健康度")
    @ResponseBody
    @RequestMapping(value = "/analyseStudentHealthOfNet", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statisStudentSurfInternetMonthREQ",value = "学生请求实体类",
                    required = true, paramType = "body", dataType = "StatisStudentSurfInternetMonthREQ")
    })
    @AccessLogger("学生上网健康度")
    public JsonResult analyseStudentHealthOfNet(@RequestBody StatisStudentSurfInternetMonthREQ statisStudentSurfInternetMonthREQ) {
        return buildSuccJson(statisStudentSurfInternetMonthService.netHealthRatio(statisStudentSurfInternetMonthREQ.getStudentNo()));
    }


    @ApiOperation(value = "群体画像(准时上课情况)")
    @ResponseBody
    @RequestMapping(value = "/onTimeForClass", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentRestREQ",value = "学生信息请求实体类|按需求传入参数",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("群体画像(准时上课情况)")
    public JsonResult onTimeForClass(@RequestBody StudentInfoREQ studentRestREQ) {
        return buildSuccJson(statisStudentCourseTimeService.onTimeForClass(studentRestREQ));
    }



    /**********************************************************************************************/
    /**********************************************************************************************/
    /**********************************************************************************************/

    @Autowired
    private IStudentSupportInfoService studentSupportInfoService;


    @ApiOperation(value = "群体画像(贫困生情况分析)")
    @ResponseBody
    @RequestMapping(value = "/poorStudentsInfo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentRestREQ",value = "学生信息请求实体类|按需求传入参数",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("群体画像(贫困生情况分析)")
    public JsonResult poorStudentsInfo(@RequestBody StudentInfoREQ studentRestREQ) {
        return buildSuccJson(studentSupportInfoService.poorStudentsInfo(studentRestREQ));
    }


    @ApiOperation(value = "贫困生分页包括非贫困生查询)")
    @ResponseBody
    @RequestMapping(value = "/pageListPoorStudent", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentInfoREQ",value = "学生分页请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentInfoREQ")
    })
    @AccessLogger("贫困生分页包括非贫困生查询")
    public JsonResult pageListPoorStudent(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(studentSupportInfoService.pageListPoorStudent(pageStudentInfoREQ));
    }


    @ApiOperation(value = "贫困生分页查询)")
    @ResponseBody
    @RequestMapping(value = "/pageListSupportStudent", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentSupportREQ",value = "学生分页请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentSupportREQ")
    })
    @AccessLogger("贫困生分页查询")
    public JsonResult pageListSupportStudent(@RequestBody PageStudentSupportREQ pageStudentSupportREQ) {
        return buildSuccJson(studentSupportInfoService.pageListSupportStudent(pageStudentSupportREQ));
    }

    @ApiOperation(value = "贫困生是否关注操作)")
    @ResponseBody
    @RequestMapping(value = "/changeSupportFocus", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentSupportREQ",value = "学生分页请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentSupportREQ")
    })
    @AccessLogger("贫困生是否关注操作")
    public JsonResult changeSupportFocus(@RequestBody StudentSupportInfo studentSupportInfo) {
        studentSupportInfoService.updateStudentSupportFocus(studentSupportInfo);
        return buildSuccJson();
    }



    /*********************************************************************************************/
    /******************************学业情况分析**************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    /*********************************************************************************************/
    @Autowired
    private IStudentScoresService studentScoresService;
    @Autowired
    private IStudentCourseService studentCourseService;

    /**
     * 查询学生历史成绩信息
     * @param studentNo
     * @return
     */
    @ApiOperation(value="查询学生历史成绩信息")
    @ResponseBody
    @RequestMapping(value="/queryHistoryScore",method= RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("查询学生历史成绩信息")
    public JsonResult queryHistoryScore(@RequestParam(value="studentNo", required=true) String studentNo) {
        return buildSuccJson(studentScoresService.queryHistoryScore(studentNo));
    }

    /**
     * 查询学生疑似逃课信息
     * @param studentNo
     * @return
     */
    @ApiOperation(value="查询学生疑似逃课信息")
    @ResponseBody
    @RequestMapping(value="/querySuspectedTruancyInfo",method= RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("查询学生疑似逃课信息")
    public JsonResult querySuspectedTruancyInfo(@RequestParam(value="studentNo", required=true) String studentNo) {
        return buildSuccJson(studentCourseService.querySuspectedTruancyInfo(studentNo));
    }

    /**
     * 查询学生学习标签
     * @param studentNo
     * @return
     */
    @RequestMapping(value="/queryStudiesLabel",method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查询学生学习标签")
    @ApiImplicitParams({@ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("查询学生学习标签")
    public JsonResult queryStudiesLabel(@RequestParam(value="studentNo", required=true) String studentNo) {
        return buildSuccJson(statisStudentCourseService.queryStudiesLabel(studentNo));
    }

    /**
     * 查询学生到课率
     * @param studentNo
     * @param queryType
     * @return
     */
    @ApiOperation(value="查询学生到课率")
    @ApiImplicitParams({@ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String"),@ApiImplicitParam(name="queryType",value="查询类型",required = true,paramType = "query",dataType = "String")})
    @RequestMapping(value="/queryClassRate",method= RequestMethod.POST)
    @ResponseBody
    @AccessLogger("查询学生到课率")
    public JsonResult queryClassRate(@RequestParam(value="studentNo", required=true) String studentNo,
                                 @RequestParam(value="queryType", required=true) String queryType) {
        return buildSuccJson(statisStudentCourseService.queryClassRate(studentNo,queryType));
    }

    /**
     * 查询分析学生到课时间
     * @param studentNo
     * @return
     */
    @ApiOperation(value="查询分析学生到课时间")
    @ApiImplicitParams({@ApiImplicitParam(name="studentNo",value="学号",required = true,paramType = "query",dataType = "String")})
    @RequestMapping(value="/queryAnalysisClassRateTime",method= RequestMethod.POST)
    @ResponseBody
    @AccessLogger("查询分析学生到课时间")
    public JsonResult queryClassTime(@RequestParam(value="studentNo", required=true) String studentNo) {
        return buildSuccJson(statisStudentCourseService.queryAnalysisClassRateTime(studentNo));
    }

    /**
     * 查询学生本学期考勤明细
     * @param pageStudentInfoREQ
     * @return
     */
    @ApiOperation(value = "查询学生本学期考勤明细")
    @ResponseBody
    @RequestMapping(value = "/pageClassAttendanceDetail", method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(name = "pageStudentInfoREQ",value = "分页学生实体类",required = true, paramType = "body", dataType = "PageStudentInfoREQ")})
    @AccessLogger("查询学生本学期考勤明细")
    public JsonResult pageClassAttendanceDetail(@RequestBody PageStudentInfoREQ pageStudentInfoREQ  ) {
        return buildSuccJson(statisStudentCourseService.pageClassAttendanceDetail(pageStudentInfoREQ));
    }

    /**
     * 似逃课情况(整体画像）
     * @param pageStudentInfoREQ
     * @return
     */
    @ApiOperation(value = "疑似逃课情况(整体画像）")
    @ResponseBody
    @RequestMapping(value = "/queryAllSuspectedTruancyInfo", method = {RequestMethod.POST})
    @ApiImplicitParams({@ApiImplicitParam(name = "studentInfoREQ",value = "学生实体类",required = true, paramType = "body", dataType = "StudentInfoREQ")})
    @AccessLogger("疑似逃课情况(整体画像）")
    public JsonResult queryAllSuspectedTruancyInfo(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(statisStudentCourseService.queryAllSuspectedTruancyInfo(pageStudentInfoREQ.getStudentInfoREQ()));
    }

    /**
     * 查询逃课学生明细信息(综合画像)
     * @return
     * @throws PlatformException
     */
    @ApiOperation(value="查询逃课学生明细信息(综合画像)")
    @ResponseBody
    @RequestMapping(value="/pageAllSuspectedTruancyInfo",method= RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(name="pageStudentInfoREQ",value="分页学生实体类",required = true,paramType = "body",dataType = "PageStudentInfoREQ")})
    @AccessLogger("查询逃课学生明细信息(综合画像)")
    public JsonResult pageAllSuspectedTruancyInfo(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(statisStudentCourseService.pageAllSuspectedTruancyInfo(pageStudentInfoREQ));
    }

}
