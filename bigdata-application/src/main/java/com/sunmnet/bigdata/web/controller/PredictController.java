package com.sunmnet.bigdata.web.controller;


import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.request.predict.PagePredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.request.predict.PredictFailSubjectREQ;
import com.sunmnet.bigdata.web.model.request.student.StudentInfoREQ;
import com.sunmnet.bigdata.web.service.predict.IPredictStudentSubjectsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/predict")
public class PredictController extends BaseController {

    public static Integer pageNum;
    public static Integer pageSize;

    @Autowired
    IPredictStudentSubjectsService predictStudentSubjectsService;

    @ApiOperation(value = "根据过往成绩预警挂科数量")
    @ResponseBody
    @RequestMapping(value = "/studentScore", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentInfoREQ",value = "学生请求实体类|需要传入学生学号",
                    required = true, paramType = "body", dataType = "StudentInfoREQ")
    })
    @AccessLogger("根据过往成绩预警挂科数量")
    public JsonResult studentScore(@RequestBody StudentInfoREQ studentInfoREQ) {
        return buildSuccJson(
                predictStudentSubjectsService.scorePrediction(studentInfoREQ.getStudentNo()));
    }


    @ApiOperation(value = "根据条件查询每个院的挂科人数")
    @ResponseBody
    @RequestMapping(value = "/countGradeByFailSubject",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "predictFailSubjectREQ",value = "学院挂科请求实体类|根据需要传入查询条件",
                    required = false, paramType = "body", dataType = "PredictFailSubjectREQ")
    })
    @AccessLogger("根据条件查询每个院的挂科人数")
    public JsonResult countGradeByFailSubject(@RequestBody PredictFailSubjectREQ predictFailSubjectREQ){
        return buildSuccJson(
                predictStudentSubjectsService.countGradeByFailSubject(predictFailSubjectREQ));

    }


    @ApiOperation(value = "根据条件查询每个院的挂科人数的详细信息")
    @ResponseBody
    @RequestMapping(value = "/pageGradeDetailByFailSubject",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pagePredictFailSubjectREQ",value = "分页学院挂科请求实体类|根据需要传入查询条件",
                    required = false, paramType = "body", dataType = "PagePredictFailSubjectREQ"),
    })
    @AccessLogger("根据条件查询每个院的挂科人数的详细信息")
    public JsonResult pageGradeDetailByFailSubject(@RequestBody PagePredictFailSubjectREQ pagePredictFailSubjectREQ){
        return buildSuccJson(
                predictStudentSubjectsService.pageGradeDetailByFailSubject(pagePredictFailSubjectREQ));

    }
}
