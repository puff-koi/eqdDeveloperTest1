package com.springboot.eqd.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 处理结构体参数校验异常
     * @param e 参数校验异常
     * @return 错误响应
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CustomRestResult<Object> bindExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException ex) {
        String result = "";
        MethodArgumentNotValidException methodArgumentNotValidException = ex;
        for (FieldError fieldErro : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            result += "【" + fieldErro.getDefaultMessage() + "】"; //fieldErro.getField() + ":" +
        }
        return CustomRestResult.failure(result);
    }
}
