package MODELS.EXCEPTIONS;

public class DadosInvalidosException extends RuntimeException {

    public DadosInvalidosException() {
    }

    public DadosInvalidosException(String message) {
        super(message);
    }

    public DadosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }

    public DadosInvalidosException(Throwable cause) {
        super(cause);
    }

    public DadosInvalidosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
