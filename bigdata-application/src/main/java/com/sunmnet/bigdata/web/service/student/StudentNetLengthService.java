package com.sunmnet.bigdata.web.service.student;

import java.util.List;

import com.sunmnet.bigdata.web.model.response.student.StudentNetDate;


public interface StudentNetLengthService {
	
	StudentNetDate getNetLength(String code,List<String> dateList);

}
