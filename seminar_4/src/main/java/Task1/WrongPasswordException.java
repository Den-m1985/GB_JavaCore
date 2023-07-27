package Task1;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Длина password должна быть менее 20 символов, " +
                "или password и confirmPassword неравны");
    }

    public WrongPasswordException(String expected, String current) {
        super(String.format("Длина password должна быть менее %s символов, " +
                "пришло %s символов. Или password и confirmPassword неравны"
                ,expected, current));
    }
}
