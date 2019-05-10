/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.dao.student.IStudentBookBorrowDAO;
import com.sunmnet.bigdata.web.service.student.IStudentBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName StudentBookBorrowServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("StudentBookBorrowServiceImpl")
public class StudentBookBorrowServiceImpl  implements IStudentBookBorrowService {

    @Autowired
    private IStudentBookBorrowDAO studentBookBorrowDAO;

    /**
     * 最近六个月图书借阅次数
     *
     * @return
     */
    @Override
    public List<Map<String,Object>> countBookBorrowByLatestSixMonth() {
        return studentBookBorrowDAO.countBookBorrowByLatestSixMonth();
    }

    /**
     * 图书借阅频次排名（学院、专业）前五
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countBookBorrowByCollegeCode() {
        return studentBookBorrowDAO.countBookBorrowByCollegeCode();
    }
}
