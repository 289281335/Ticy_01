package com.sunmnet.bigdata.web.controller;

import com.sunmnet.bigdata.commons.model.JsonResult;
import com.sunmnet.bigdata.web.logging.AccessLogger;
import com.sunmnet.bigdata.web.model.entity.basedata.DictDictionary;
import com.sunmnet.bigdata.web.service.basedata.IDictDictionaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典控制器
 */
@RestController
@RequestMapping(value="/dict/dictionary")
public class DictDictionaryController extends BaseController{
    @Autowired
    IDictDictionaryService dictDictionaryService;
    /**
     * 根据字典代码获取字典列表
     * @param code
     * @return
     */
    @ApiOperation(value="根据字典代码获取字典列表")
    @RequestMapping(value="/queryDictDictionaryByCode",method = {RequestMethod.POST})
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name="code",value="字典代码code",required = true,paramType = "query",dataType = "String")})
    @AccessLogger("根据字典代码获取字典列表")
    public JsonResult queryDictDictionaryByCode(@RequestParam(value="code") String code) {
        return buildSuccJson(dictDictionaryService.queryDictDictionaryByCode(code));
    }
}
