/*
 * Copyright (c) 2018-2046, sunmnet Inc. All Rights Reserved.
 *
 * Project Name: bigdata
 * date:  2018-01-30 09:48:58
 */
package com.sunmnet.bigdata.web.service.basedata.impl;

import com.sunmnet.bigdata.web.dao.basedata.IDictDictionaryDAO;
import com.sunmnet.bigdata.web.model.entity.basedata.DictDictionary;
import com.sunmnet.bigdata.web.service.basedata.IDictDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wdong
 * @version 1.0
 * @ClassName DictDictionaryServiceImpl
 * @Description
 * @date 2018-01-30 09:48:58
 */
@Transactional
@Service("DictDictionaryServiceImpl")
public class DictDictionaryServiceImpl implements IDictDictionaryService {
    @Autowired
    private IDictDictionaryDAO dictDictionaryDAO;


    @Override
    public List<DictDictionary> queryDictDictionaryByCode(String code) {
        return dictDictionaryDAO.queryDictDictionaryByCode(code);
    }
}
