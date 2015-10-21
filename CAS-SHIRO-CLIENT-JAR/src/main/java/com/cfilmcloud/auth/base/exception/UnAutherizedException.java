package com.cfilmcloud.auth.base.exception;

/**
 * 未认证异常，该异常是为 spring mvc 异常方法签名提供的异常，当出现该异常时，会自动跳转到登录页面。
 */
@SuppressWarnings("serial")
public class UnAutherizedException extends ServiceException {

    /**
     * 未认证异常，该异常是为 spring mvc 异常方法签名提供的异常
     */
    public UnAutherizedException() {
        super();
    }

    /**
     * 未认证异常，该异常是为 spring mvc 异常方法签名提供的异常
     *
     * @param message 异常信息
     */
    public UnAutherizedException(String message) {
        super(message);
    }

    /**
     * 未认证异常，该异常是为 spring mvc 异常方法签名提供的异常
     *
     * @param cause 异常类
     */
    public UnAutherizedException(Throwable cause) {
        super(cause);
    }

    /**
     * 未认证异常，该异常是为 spring mvc 异常方法签名提供的异常
     *
     * @param message 异常信息
     * @param cause   异常类
     */
    public UnAutherizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
