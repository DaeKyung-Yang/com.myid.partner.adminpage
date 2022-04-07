package iconloop.myid.partner.adminpage.exception.code;

import lombok.Getter;

@Getter
public enum CommonErrorCode {
    SUCCESS(0, "SUCCESS"),
    UNAUTHORIZED( 401,"Unauthorized."),
    USER_NOT_FOUND(402, "User not found."),
    USER_DISABLED(403, "User disabled."),
    PASSWORD_INCORRECT(404, "Password incorrect."),
    PASSWORD_IS_NULL(405, "Password is null."),
    PASSWORD_IS_REQUIRED_UPDATE(406, "Password is required update."),
    DUPLICATE_SESSION(407, "Duplicate session."),
    PASSWORD_INCORRECT_OVER(408, "Password incorrect limit count over."),
    ALREADY_EXIST_USER(409, "Already exist user."),
    ALREADY_AUTH_USER(410, "Already authorized user."),
    TOKEN_EXPIRED(411, "Token is expired."),
    AUTH_CODE_INCORRECT(412, "AuthCode Incorrect."),
    EMAIL_FORMAT_ERROR(413, "Email format is incorrect."),
    EMAIL_TERM_ERROR(414, "Email send time too early."),
    ALREADY_USED_PASSWORD(415, "Already used password."),
    NOT_SUPPORT_ROLE(416, "Not support accRole."),
//    INVITE_TOKEN_EXPIRED(416, "Token is expired.(invite)"),
//    PASSWORD_TOKEN_EXPIRED(417, "Token is expired.(password)"),

    CRYPTO_ERROR(9000, "Crypto error."),
    UNDEFINED_ERROR(9999, "Undefined error.");

    private Integer code;
    private String message;

    CommonErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
