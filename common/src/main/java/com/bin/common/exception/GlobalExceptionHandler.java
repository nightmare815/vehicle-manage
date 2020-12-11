package com.bin.common.exception;

import com.bin.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error().message("未知错误!");
    }


    //自定义异常处理
    @ExceptionHandler(com.bin.common.exception.MyException.class)
    @ResponseBody
    public Result error(com.bin.common.exception.MyException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMessage());
    }
}
