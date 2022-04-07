package com.springboot.eqd.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRestResult<T> implements Serializable {
    public static final String OK = "200";
    public static final String ERROR = "400";

    public static final String CONTACTUS = "如有异常请即时反馈";

    public static final String SUCCESS_MSG = "success";

    private T result;
    private String code;

    private String msg;

    static public <T> CustomRestResult<T> successWith(T data, String errCode, String errMsg) {
        return new CustomRestResult<>(data, errCode, errMsg);
    }

    static public <T> CustomRestResult<T> success(String msg) {
        return successWith(null, OK, msg);
    }

    static public <T> CustomRestResult<T> success() {
        return successWith(null, OK, SUCCESS_MSG);
    }

    static public <T> CustomRestResult<T> success(T data) {
        return successWith(data, OK, SUCCESS_MSG);
    }

    static public <T> CustomRestResult<T> success(T data, String msg) {
        return successWith(data, OK, msg);
    }

    static public <T> CustomRestResult<T> failureWith(T data, String errCode, String errMsg) {
        return new CustomRestResult<>(data, errCode, errMsg);
    }
    static public <T> CustomRestResult<T> failureWith( String errCode, String errMsg) {
        return new CustomRestResult<>(null, errCode, errMsg);
    }
    static public <T> CustomRestResult<T> failure(String msg){
        return failureWith(null, ERROR, msg);
    }

    static public <T> CustomRestResult<T> failure(String msg,String code){
        return failureWith(null, ERROR, msg);
    }

    static public <T> CustomRestResult<T> failure(T data, String msg) {
        return failureWith(data, ERROR, msg);
    }
}

