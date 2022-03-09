package com.work.exception;

import com.work.core.api.ApiResult;
import com.work.core.api.ApiResultCodeMsg;
import com.work.core.api.ApiResultGenerator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理异常类
 */
@ControllerAdvice
public class GlobalMyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult handlerException(HttpServletRequest request,
                                      Exception e){
        return ApiResultGenerator.error(ApiResultCodeMsg.BAD_PARAMETER,e.getMessage());
    }

}