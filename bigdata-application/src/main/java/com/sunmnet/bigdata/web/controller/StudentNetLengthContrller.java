package com.sunmnet.bigdata.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.sunmnet.bigdata.web.model.response.student.StudentNetDate;
import com.sunmnet.bigdata.web.service.student.StudentNetLengthService;


@Controller
public class StudentNetLengthContrller {

	@Autowired
	StudentNetLengthService studentNetLengthService;
	
	@GetMapping("/netLength")
    @ResponseBody
    public Object getNetLength(String code) {
		List<String> dateList  = new ArrayList<String>();
		
		dateList.add("2017-10-26");
		
        StudentNetDate netLength = studentNetLengthService.getNetLength(code, dateList);
        
        return netLength;
    }
}
