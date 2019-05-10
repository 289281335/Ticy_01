/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.school;

import com.sunmnet.bigdata.web.model.entity.school.SchoolInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName ISchoolInfoService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface ISchoolInfoService {

    List<SchoolInfo> listAllCollege();

    List<SchoolInfo> listMajorByCollege(@Param("collegeCode") String collegeCode);

    List<SchoolInfo> listClassByMajor(@Param("majorCode") String majorCode);

    List<SchoolInfo> listAllMajor();

}
