package com.xlkj.website.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String retCode;
    private String reason;

    public BusinessException(String retCode, String reason) {
        this.retCode = retCode;
        this.reason = reason;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
