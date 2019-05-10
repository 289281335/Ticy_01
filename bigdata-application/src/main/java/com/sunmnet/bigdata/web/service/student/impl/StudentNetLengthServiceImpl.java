package com.sunmnet.bigdata.web.service.student.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.web.dao.student.StudentNetLengthMapper;
import com.sunmnet.bigdata.web.model.response.student.StudentNetDate;
import com.sunmnet.bigdata.web.service.student.StudentNetLengthService;


@Service
public class StudentNetLengthServiceImpl implements StudentNetLengthService {

	@Autowired
	private StudentNetLengthMapper studentNetLengthMapper; 
	
	@Override
	public StudentNetDate getNetLength(String code, List<String> dateMonthList) {
		
		StudentNetDate studentNetDate = new StudentNetDate();
		ArrayList<Map<String, Object>> dateList = new ArrayList<Map<String, Object>>();
		
		
		for (String date : dateMonthList) {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("code", code);
			paramMap.put("date", date);
			
			String netLength = studentNetLengthMapper.getNetLength(paramMap);
			paramMap.clear();
			paramMap.put("date", date);
			paramMap.put("netLength", Math.ceil(Double.parseDouble(netLength)/3600));
			dateList.add(paramMap);
		}
		studentNetDate.setCode(code);
		studentNetDate.setDateList(dateList);
		
		return studentNetDate;
	}

	
}
