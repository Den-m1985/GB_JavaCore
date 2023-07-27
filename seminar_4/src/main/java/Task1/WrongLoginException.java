package Task1;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException() {
        super("Длина login должна быть не менее 20 символов");
    }

    public WrongLoginException(String expected, String current) {
        super(String.format("Длина login должна быть больше %s символов, " +
                "пришло %s символов",expected, current));
    }
}
