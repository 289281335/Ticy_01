/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */

package com.sunmnet.bigdata.web.service.basedata;

import com.sunmnet.bigdata.web.model.entity.basedata.DictDictionary;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName IDictDictionaryService
 * @Description
 * @date 2018-01-30 09:48:58
 */
public interface IDictDictionaryService {
    /**
     * 根据Code获取字典列表
     * @param code
     * @return
     */
    List<DictDictionary> queryDictDictionaryByCode(String code);
}
