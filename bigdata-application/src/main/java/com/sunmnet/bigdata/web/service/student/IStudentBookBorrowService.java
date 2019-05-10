/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.student;

import java.util.List;
import java.util.Map;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IStudentBookBorrowService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IStudentBookBorrowService {
    /**
     * 最近六个月图书借阅次数
     * @return
     */
    List<Map<String,Object>> countBookBorrowByLatestSixMonth();

    /**
     * 图书借阅频次排名（学院、专业）前五
     * @return
     */
    List<Map<String,Object>> countBookBorrowByCollegeCode();


}
