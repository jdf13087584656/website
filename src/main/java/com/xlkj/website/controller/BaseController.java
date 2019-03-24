package com.xlkj.website.controller;

import com.xlkj.website.exception.BusinessException;
import com.xlkj.website.exception.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class BaseController {


    protected ResponseEntity collectionException(Throwable e) {
        BusinessException exception = (e instanceof BusinessException) ? (BusinessException) e
//                : new BusinessException("0500001",e.getMessage());
                : new BusinessException("000100","网络异常");
        log.error("处理异常数据 retcode = {}, reason = {}, message = {}", exception.getRetCode(), exception.getReason(), e.getMessage());
        if (log.isDebugEnabled()) {
            e.printStackTrace();
        }
             Result result = new Result();
            result.setRetCode(exception.getRetCode());
            result.setReason(exception.getReason());
        return ResponseEntity.ok(result);
    }



}
