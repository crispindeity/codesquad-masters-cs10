package findarea;

public class ExceededInputCountException extends RuntimeException {

    private final int errCode;

    public ExceededInputCountException(String message) {
        this(message, 200);
    }

    public ExceededInputCountException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrorCode() {
        return errCode;
    }
}