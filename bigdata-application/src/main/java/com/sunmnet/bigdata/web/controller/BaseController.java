package com.sunmnet.bigdata.web.controller;


import com.sunmnet.bigdata.commons.model.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
public abstract class BaseController {
    protected JsonResult buildErrJson(String msg) {
        return buildJson(false, "9999", msg, null);
    }

    protected JsonResult buildErrJson(String errorCode, String msg) {
        return buildJson(false, errorCode, msg, null);
    }

    protected JsonResult buildSuccJson() {
        return buildSuccJson(null);
    }

    protected JsonResult buildSuccJson(Object obj) {
        return buildJson(true, null, "成功", obj);
    }

    protected JsonResult buildJson(Boolean success, String errorCode, String msg) {
        return buildJson(success, errorCode, msg, null);
    }

    protected JsonResult buildJson(Boolean success, String errorCode, String msg, Object obj) {
        JsonResult result = new JsonResult();
        result.setSuccess(success);
        result.setErrorCode(errorCode);
        result.setMsg(msg);
        result.setObj(obj);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception ex, HttpServletRequest req, HttpServletResponse res) {
        ex.printStackTrace();
        return buildErrJson("-1","服务异常");
    }


}
