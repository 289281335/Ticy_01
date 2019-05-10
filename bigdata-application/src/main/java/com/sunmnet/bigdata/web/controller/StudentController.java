package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.request.student.*;
import com.sunmnet.bigdata.web.service.student.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StudentController extends BaseController {

    @Autowired
    IStudentAwardService iStudentAwardService;


    @Autowired
    IStudentInfoService iStudentInfoService;


    @Autowired
    IStudentExtracurrCreditsService iStudentExtracurrCreditsService;




    @ApiOperation(value = "根据学号查询学生获奖情况")
    @ResponseBody
    @RequestMapping(value = "/listAwardByStudentNo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据学号查询学生获奖情况")
    public JsonResult listAwardByStudentNo(@RequestBody StudentInfoREQ studentInfoREQ){
        return buildSuccJson(iStudentAwardService.listAwardByStudentNo(studentInfoREQ.getStudentNo()));
    }


    @ApiOperation(value = "根据学号查询学生课程表情况")
    @ResponseBody
    @RequestMapping(value = "/listAwardByStudentNoAndCategory", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据学号查询学生课程表情况")
    public JsonResult listAwardByStudentNoAndCategory(@RequestBody StudentInfoREQ studentInfoREQ){
        return buildSuccJson(iStudentAwardService.listAwardByStudentNoAndCategory(studentInfoREQ.getStudentNo()));
    }




    @ApiOperation(value = "通过学号获取学生相关信息")
    @ResponseBody
    @RequestMapping(value = "/getStudentByNo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
            required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("通过学号获取学生相关信息")
    public JsonResult getStudentByNo(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentInfoService.getStudentByNo(studentInfoREQ.getStudentNo()));
    }


    @ApiOperation(value = "分页获取学生信息")
    @ResponseBody
    @RequestMapping(value = "/pageStudentInfo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentInfoREQ",value = "学生分页请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentInfoREQ")
    })
    @AccessLogger("分页获取学生信息")
    public JsonResult pageStudentInfo(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(iStudentInfoService.pageStudentInfo(pageStudentInfoREQ));
    }

    @Autowired
    private IStudentPositionService iStudentPositionService;

    @ApiOperation(value = "根据学号查询学生任职情况")
    @ResponseBody
    @RequestMapping(value = "/listPosition", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据学号查询学生任职情况")
    public JsonResult listPosition(@RequestBody StudentInfoREQ studentInfoREQ)  {
        return buildSuccJson(iStudentPositionService.listPosition(studentInfoREQ.getStudentNo()));
    }


    /*********************************************************************************/
    /**************************学生上网*******************************************************/
    /*********************************************************************************/
    /*********************************************************************************/



    @Autowired
    private IStudentNetTimeInfoService iStudentNetTimeInfoService;


    @ApiOperation(value = "通过学号查询最近7天上网情况")
    @ResponseBody
    @RequestMapping(value = "/listSurfInternetOfWeek", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("通过学号查询最近7天上网情况")
    public JsonResult listSurfInternetOfWeek(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentNetTimeInfoService.nearly7dayNetInfo(studentInfoREQ.getStudentNo()));
    }


    /*********************************************************************************/
    /**************************学生社交关系*******************************************************/
    /*********************************************************************************/
    /*********************************************************************************/

    @Autowired
    IStudentSocialFriendService iStudentSocialFriendService;

    @ApiOperation(value = "根据学号找到学生社交圈")
    @ResponseBody
    @RequestMapping(value = "/sociaFriends", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentSocialFriendREQ",value = "学生关系请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentSocialFriendREQ")
    })
    @AccessLogger("根据学号找到学生社交圈")
    public JsonResult sociaFriends(@RequestBody StudentSocialFriendREQ studentSocialFriendREQ) {
        return buildSuccJson(iStudentSocialFriendService.studentRelations(studentSocialFriendREQ.getStudentNo()));
    }


    @ApiOperation(value = "获得个人画像-综合画像个人选项卡社交信息")
    @ResponseBody
    @RequestMapping(value = "/studentRelationLabel", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentSocialFriendREQ",value = "学生关系请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentSocialFriendREQ")
    })
    @AccessLogger("获得个人画像-综合画像个人选项卡社交信息")
    public JsonResult studentRelationLabel(@RequestBody StudentSocialFriendREQ studentSocialFriendREQ) {
        return buildSuccJson(iStudentSocialFriendService.studentRelationLabel(studentSocialFriendREQ.getStudentNo()));
    }

    @ApiOperation(value = "综合画像-社交群体关系")
    @ResponseBody
    @RequestMapping(value = "/socialRelation", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentSocialFriendREQ",value = "学生关系请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentSocialFriendREQ")
    })
    @AccessLogger("综合画像-社交群体关系")
    public JsonResult socialRelation(@RequestBody StudentSocialFriendREQ studentSocialFriendREQ) {
        return buildSuccJson(iStudentSocialFriendService.listSocialRelation(studentSocialFriendREQ));
    }


    /*********************************************************************************/
    /**************************学生消费指数*******************************************************/
    /*********************************************************************************/
    /*********************************************************************************/
    @Autowired
    private IStudentConsumptionIndexService iStudentConsumptionIndexService;

    @ApiOperation(value = "综合画像-社交，餐饮，学习，贫困学生整体统计")
    @ResponseBody
    @RequestMapping(value = "/consumptionIndex", method = {RequestMethod.POST})
    @AccessLogger("综合画像-社交，餐饮，学习，贫困学生整体统计")
    public Object consumptionIndex() {
        Map<String, Object> map = new HashMap<>();
        map.put("diet", iStudentConsumptionIndexService.eatState());
        map.put("social", iStudentConsumptionIndexService.socialState());
        map.put("study", iStudentConsumptionIndexService.studyState());
        map.put("poorstudent", iStudentConsumptionIndexService.poorPeople());
        map.put("web",iStudentConsumptionIndexService.webState());
        map.put("sleepandgetup", iStudentConsumptionIndexService.sleepState());

        return buildSuccJson(map);
    }


    /*********************************************************************************/
    /**************************学生睡眠信息分析——学生起止时间***********************/
    /*********************************************************************************/
    /*********************************************************************************/

    @Autowired
    private IStudentRestService iStudentRestService;

    @ApiOperation(value = "通过学号查询最近7天睡眠情况")
    @ResponseBody
    @RequestMapping(value = "/latestSleepSituation", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("通过学号查询最近7天睡眠情况")
    public JsonResult latestSleepSituation(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentRestService.last7DaysRest(studentInfoREQ.getStudentNo()));
    }

    @ApiOperation(value = "查询睡眠时长")
    @ResponseBody
    @RequestMapping(value = "/sleepTime", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("查询睡眠时长")
    public JsonResult sleepTime(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentRestService.sleepTime(studentInfoREQ.getStudentNo()));
    }

    @ApiOperation(value = "查询睡眠规律度")
    @ResponseBody
    @RequestMapping(value = "/sleepRegularity", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("查询睡眠规律度")
    public JsonResult sleepRegularity(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentRestService.sleepRegularity(studentInfoREQ.getStudentNo()));
    }


    @ApiOperation(value = "查询睡眠标签")
    @ResponseBody
    @RequestMapping(value = "/sleepLable", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("查询睡眠标签")
    public JsonResult sleepLable(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentRestService.sleepLable(studentInfoREQ.getStudentNo()));
    }

    @ApiOperation(value = "查询睡眠时长(综合画像)")
    @ResponseBody
    @RequestMapping(value = "/sleepTimeOfTeam", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentRestREQ",value = "学生信息睡眠请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentRestREQ")
    })
    @AccessLogger("查询睡眠时长(综合画像)")
    public JsonResult sleepTimeOfTeam(@RequestBody StudentRestREQ studentRestREQ) {
        return buildSuccJson(iStudentRestService.sleepTimeOfTeam(studentRestREQ));
    }


    @ApiOperation(value = "查询睡觉时间点比率(群体画像)")
    @ResponseBody
    @RequestMapping(value = "/sleepRateOfTeam", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentRestREQ",value = "学生信息睡眠请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentRestREQ")
    })
    @AccessLogger("查询睡觉时间点比率(群体画像)")
    public JsonResult sleepRateOfTeam(@RequestBody StudentRestREQ studentRestREQ) {
        return buildSuccJson(iStudentRestService.sleepRateOfTeam(studentRestREQ));
    }


    @ApiOperation(value = "查询起床时间点比率(综合画像)")
    @ResponseBody
    @RequestMapping(value = "/getUpRateOfTeam", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentRestREQ",value = "学生信息睡眠请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentRestREQ")
    })
    @AccessLogger("查询起床时间点比率(综合画像)")
    public JsonResult getUpRateOfTeam(@RequestBody StudentRestREQ studentRestREQ) {
        return buildSuccJson(iStudentRestService.getUpRateOfTeam(studentRestREQ));
    }

    @ApiOperation(value = "根据学号查询学生课外八学分情况")
    @ResponseBody
    @RequestMapping(value = "/class8creditsByStudentNo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据学号查询学生课外八学分情况")
    public JsonResult class8credits(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentExtracurrCreditsService.class8creditsByStudentNo(studentInfoREQ.getStudentNo()));
    }


    @Autowired
    IStudentScoresService iStudentScoresService;

    @ApiOperation(value = "查询学生的所有成绩(个人画像--成绩图)")
    @ResponseBody
    @RequestMapping(value = "/gradePredictionByStudentNo", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("查询学生的所有成绩(个人画像--成绩图)")
    public JsonResult listScoresByStudentNo(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(iStudentScoresService.
                listScoresByStudentNo(studentInfoREQ.getStudentNo()));
    }


    @ApiOperation(value = "分页学生成绩")
    @ResponseBody
    @RequestMapping(value = "/pageStudentScore", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageStudentInfoREQ",value = "学生分页请求实体类|根据需要传入查询条件",
                    required = true, paramType = "body", dataType = "PageStudentInfoREQ")
    })
    @AccessLogger("分页学生成绩")
    public JsonResult pageStudentScore(@RequestBody PageStudentInfoREQ pageStudentInfoREQ) {
        return buildSuccJson(iStudentScoresService.pageStudentScores(pageStudentInfoREQ));
    }


    /*********************************************************************************/
    /***********************************学生成长目标信息*******************************/
    /*********************************************************************************/
    /*********************************************************************************/

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private IStudentGraduationTargetService iStudentGraduationTargetService;

    @ApiOperation(value = "学生成长目标信息保存")
    @ResponseBody
    @RequestMapping(value = "/saveArgetInfo",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类",
            required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长目标信息保存")
    public JsonResult saveArgetInfo(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
            try {
                JsonResult result = iStudentGraduationTargetService.saveArgetInfo(studentGraduationTargetREQ);
                if (result.getSuccess()){
                    return buildSuccJson();
                }else {
                    return buildErrJson(result.getMsg());
                }
            }catch (Exception e){
                logger.error("设置成长目标失败;详情StudentNo:"+ studentGraduationTargetREQ.getStudentNo()+"argetType:"+ studentGraduationTargetREQ.getArgetType()+
                        "CollegeCode:"+ studentGraduationTargetREQ.getSchoolCode()+"industryCode:"+ studentGraduationTargetREQ.getIndustryCode()+"argetWorkInfo:"+ studentGraduationTargetREQ.getPositionCode(),e);
                return buildErrJson("设置成长目标失败");
            }
        }

    @ApiOperation(value = "根据学号查询学生有没有设置成长目标")
    @ResponseBody
    @RequestMapping(value = "/isArgetInfo",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("根据学号查询学生有没有设置成长目标")
    public JsonResult isArgetInfo(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            String argetStatus = iStudentGraduationTargetService.isArget(studentGraduationTargetREQ);
            Map<String,String> map = new HashMap<String,String>();
            map.put("argetStatus",argetStatus);
            return buildSuccJson(map);
        }catch (Exception e){
            logger.error("查询学生有没有设置成长目标异常",e);
            return buildErrJson("查询学生有没有设置成长目标失败");
        }
    }


    @ApiOperation(value = "根据学号查询学生成长目标信息")
    @ResponseBody
    @RequestMapping(value = "/getArgetInfo",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("根据学号查询学生成长目标信息")
    public JsonResult getArgetInfo(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult result = iStudentGraduationTargetService.getArgetInfo(studentGraduationTargetREQ);
            if (result.getSuccess()){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("argetInfo",result.getObj());
                return  buildSuccJson(map);
            }else {
                return buildErrJson(result.getMsg());
            }
        }catch (Exception e){
            logger.error("查查询学生成长目标信息异常",e);
            return buildErrJson("查询学生成长目标信息失败");
        }
    }


    @ApiOperation(value = "学生成长设置成长目标群体标签统计")
    @ResponseBody
    @RequestMapping(value = "/countGroupLabel",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长设置成长目标群体标签统计")
    public JsonResult countGroupLabel(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult result = iStudentGraduationTargetService.countGroupLabel(studentGraduationTargetREQ);
            if (result.getSuccess()){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("list",result.getObj());
                return buildSuccJson(map);
            }else {
                return buildErrJson(result.getMsg());
            }
        }catch (Exception e){
            logger.error("成长目标群体标签统计失败;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("成长目标群体标签统计失败");
        }
    }


    @ApiOperation(value = "学生成长设置成长目标优秀样本展示")
    @ResponseBody
    @RequestMapping(value = "/listExcellentSample",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长设置成长目标优秀样本展示")
    public JsonResult listExcellentSample(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ) throws Exception {
         JsonResult result = iStudentGraduationTargetService.listExcellentSample(studentGraduationTargetREQ);
        try {
            if (result.getSuccess()){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("list",result.getObj());
                return  buildSuccJson(map);
            }else {
                return buildErrJson(result.getMsg());
            }
        }catch (Exception e){
            logger.error("学生成长设置成长目优秀样本展示;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("优秀样本查询失败");
        }
    }


    @ApiOperation(value = "学生成长设置成长目标群体平均展示")
    @ResponseBody
    @RequestMapping(value = "/getGroupAverage",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长设置成长目标群体平均展示")
    public JsonResult getGroupAverage(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult  result = iStudentGraduationTargetService.getGroupAverage(studentGraduationTargetREQ);
            if(result.getSuccess()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("list", result.getObj());
                return buildSuccJson(map);
            }else{
                return buildErrJson(result.getMsg());
            }
        } catch (Exception e) {
            logger.error("学生成长设置成长目群体平均展示;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("群体平均查询失败");
        }
    }


    @ApiOperation(value = "学生成长设置成长目群体相似度")
    @ResponseBody
    @RequestMapping(value = "/groupSimilarityDegree",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号and需要传入相似度查询类型",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长设置成长目群体相似度")
    public JsonResult groupSimilarityDegree(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult  result = iStudentGraduationTargetService.groupSimilarityDegree(studentGraduationTargetREQ);
            if(result.getSuccess()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("list", result.getObj());
                return buildSuccJson(map);
            }else{
                return buildErrJson(result.getMsg());
            }
        } catch (Exception e) {
            logger.error("学生成长设置成长目群体相似度展示;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("群体相似度查询失败");
        }
    }


    @ApiOperation(value = "学生成长成长目标和群体指标展示")
    @ResponseBody
    @RequestMapping(value = "/argetGroupInfo",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长成长目标和群体指标展示")
    public JsonResult argetGroupInfo(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult  result = iStudentGraduationTargetService.argetGroupInfo(studentGraduationTargetREQ);
            if(result.getSuccess()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("list", result.getObj());
                return buildSuccJson(map);
            }else{
                return buildErrJson(result.getMsg());
            }
        } catch (Exception e) {
            logger.error("学生成长成长目标和群体指标展示;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("目标和群体指标查询失败");
        }
    }


    @ApiOperation(value = "学生成长设置成长目群体超越、持平、 偏差大统计项")
    @ResponseBody
    @RequestMapping(value = "/detailedComparison",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("学生成长设置成长目群体超越、持平、 偏差大统计项")
    public JsonResult detailedComparison(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult  result = iStudentGraduationTargetService.detailedComparison(studentGraduationTargetREQ);
            if(result.getSuccess()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("list", result.getObj());
                return buildSuccJson(map);
            }else{
                return buildErrJson(result.getMsg());
            }
        } catch (Exception e) {
            logger.error("学生成长成长目标和群体指标展示;详情studentNo"+ studentGraduationTargetREQ.getStudentNo(),e);
            return buildErrJson("目标和群体指标查询失败");
        }
    }


    @ApiOperation(value = "根据学号查询学生成长目标信息（代码和名称都显示）")
    @ResponseBody
    @RequestMapping(value = "/getArgetInfoAll",method ={RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentGraduationTargetREQ",value = "成长目标请求实体类|需要传入学生学号",
                    required = true,paramType = "body",dataType = "StudentGraduationTargetREQ")
    })
    @AccessLogger("根据学号查询学生成长目标信息（代码和名称都显示）")
    public JsonResult getArgetInfoAll(@RequestBody StudentGraduationTargetREQ studentGraduationTargetREQ){
        try {
            JsonResult  result = iStudentGraduationTargetService.getArgetInfoAll(studentGraduationTargetREQ);
            if(result.getSuccess()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("list", result.getObj());
                return buildSuccJson(map);
            }else{
                return buildErrJson(result.getMsg());
            }
        } catch (Exception e) {
            logger.error("查查询学生成长目标信息（代码和名称都显示）异常",e);
            return buildErrJson("查询学生成长目标信息失败");
        }
    }
}
