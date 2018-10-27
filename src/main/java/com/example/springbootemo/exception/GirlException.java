package com.example.springbootemo.exception;

/**
 * Created by lvxin
 */
//异常处理类
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
