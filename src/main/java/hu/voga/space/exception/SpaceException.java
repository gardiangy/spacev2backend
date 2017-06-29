package hu.voga.space.exception;


import hu.voga.space.enums.ErrorCode;

public class SpaceException extends Exception {

    private ErrorCode errorCode;

    public SpaceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
