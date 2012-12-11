package oss.process.scrum.exception;

public final class AppException extends Exception {
    private static final long serialVersionUID = 4667352331931452439L;
    private String exceptionMessage;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(final String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public AppException() {
        super();
        setExceptionMessage("Unknown Exception. Please contact System Admin.");
    }

    public AppException(Exception e) {
        super(e);
        setExceptionMessage(e.getMessage());
    }

    public AppException(final String exceptionMessage) {
        super(exceptionMessage);
        setExceptionMessage(exceptionMessage);
    }

    public String getError() {
        return this.exceptionMessage;
    }
}