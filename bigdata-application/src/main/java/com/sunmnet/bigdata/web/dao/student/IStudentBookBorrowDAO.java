/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.dao.student;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentBookBorrowDAO
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentBookBorrowDAO {

    /**
     * 根据学号查询借阅数量
     * @param studentNo
     * @return
     */
    public Integer countBorrowByStudentNo(String studentNo);

    /**
     * 最近六个月图书借阅次数
     * @return
     */
    List<Map<String,Object>> countBookBorrowByLatestSixMonth();

    /**
     * 书借阅频次排名（学院、专业）前五
     * @return
     */
    List<Map<String,Object>> countBookBorrowByCollegeCode();
}
