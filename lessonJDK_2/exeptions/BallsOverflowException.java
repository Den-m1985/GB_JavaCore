package exeptions;

public class BallsOverflowException extends RuntimeException {
    public BallsOverflowException() {
        super("Невозможно создать более шаров");
    }
}
