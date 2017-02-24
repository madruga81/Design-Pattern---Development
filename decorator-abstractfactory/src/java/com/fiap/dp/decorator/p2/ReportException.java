package com.fiap.dp.decorator.p2;

public class ReportException extends RuntimeException {

    private static final long serialVersionUID = 384005374527780883L;

    public ReportException() {
        super();
    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(String message) {
        super(message);
    }

    public ReportException(Throwable cause) {
        super(cause);
    }
}
