package iconloop.myid.partner.adminpage.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus
public class BaseException extends RuntimeException{

    private String code;
    private String message;
    private long detailCode;
    private String detailMessage;

    BaseException(String message) {
        super(message);
        this.message = message;
    }

    BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    BaseException(String code, String message, long detailCode, String detailMessage) {
        super(message);
        this.code = code;
        this.message = message;
        this.detailCode = detailCode;
        this.detailMessage = detailMessage;
    }
}
