package exceptions;

public class InsufficientFundsException extends Throwable {
    InsufficientFundsException() {
        super("Insufficient Funds");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
