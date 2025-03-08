package com.fhr.cuit.exception;

/**
 * 业务异常
 *
 * @author FHR
 * @create 2025/03/08 11:44
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
