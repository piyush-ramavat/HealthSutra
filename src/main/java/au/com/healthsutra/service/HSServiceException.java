package au.com.healthsutra.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class HSServiceException extends Exception {

//    private static final Logger LOG = LoggerFactory.getLogger(HSServiceException.class);

    private String errorCode;

    private String errorSystemMessage;

    public HSServiceException(final String message) {
        super(message);
    }

    public HSServiceException(final Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorSystemMessage() {
        return errorSystemMessage;
    }

    public HSServiceException withErrorCode(final String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public HSServiceException withErrorSystemMessage(final String systemMessage) {
        this.errorSystemMessage = systemMessage;
        return this;
    }
}
