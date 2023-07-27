package Task1;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Длина password должна быть менее 20 символов");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
