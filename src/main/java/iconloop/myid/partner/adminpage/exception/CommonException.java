package iconloop.myid.partner.adminpage.exception;

import iconloop.myid.partner.adminpage.exception.code.CommonErrorCode;

public class CommonException extends BaseException{
    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(String code, String message) {
        super(code, message);
    }

    public CommonException(String code, String message, long detailCode, String detailMessage) {
        super(code, message, detailCode, detailMessage);
    }

    public CommonException(CommonErrorCode errorCode) {
        super(String.valueOf(errorCode.getCode()), errorCode.getMessage());
    }
}
