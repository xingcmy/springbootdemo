package com.example.demo.config.exception;

import lombok.Getter;
import lombok.Setter;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 错误状态码
     */
    @Getter
    @Setter
    protected Integer errorCode;
    /**
     * 错误提示
     */
    @Getter
    @Setter
    protected String errorMsg;

    public BusinessException(){}

    public BusinessException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
