package com.feyl.mall.common.result;

/**
 * @author Feyl
 * @date 2021/10/27 0:15
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "服务器暂时处于超负载或正在进行停机维护，现在无法处理请求"),
    VALIDATE_FAILED(404, "无法找到请求资源"),
    UNAUTHORIZED(401, "用户认证失败，暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关访问权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}