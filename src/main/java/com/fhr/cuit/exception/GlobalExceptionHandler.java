package com.fhr.cuit.exception;

import com.fhr.cuit.model.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author FHR
 * @create 2025/03/08 11:46
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result handleException(Exception e) {
//        log.error(e.getMessage());
//        return Result.error("系统错误！");
//    }

    @ExceptionHandler
    @ResponseBody
    public Result handleBusinessException(BusinessException e){
        log.error(e.getMessage());
        return Result.error(e.getMessage());
    }
}
