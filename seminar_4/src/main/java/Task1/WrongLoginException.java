package Task1;

public class WrongLoginException extends Exception{
    public WrongLoginException() {
        super("Длина login должна быть не менее 20 символов");
    }

    public WrongLoginException(String expected, String current) {
        super(String.format("Длина login должна быть меньше 20 символов %s %s",expected, current));
    }
}
