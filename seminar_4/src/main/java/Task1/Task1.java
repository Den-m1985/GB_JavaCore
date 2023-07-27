package Task1;

public class Task1 {

    /*
    Задание 1 Задача:   Проверка логина и пароля
    1.Создать статический метод который принимает на вход три параметра:
     login, password и confirmPassword.
    2.Длина login должна быть меньше 20 символов.
     Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
    3.Длина password должна быть меньше 20 символов.
     Также password и confirmPassword должны быть равны.
     Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
    4.WrongPasswordException и WrongLoginException - пользовательские классы исключения
     с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает
     его в конструктор класса Exception.
    5.В основном классе программы необходимо по-разному обработать исключения.
    6.Метод возвращает true, если значения верны или false в другом случае.
     */
    public static void main(String[] args) {
        String login = "ffffffffffпffffffffff";
        String password = "gdhfgbgfnfgsnf";
        String confirmPassword = "gdhfgbgfnfgsnf";
        System.out.println(loginPasw(login, password, confirmPassword));
    }

    public static boolean loginPasw(String login, String password, String confirmPassword) {
        try {
            if (login.length() <= 20) {
                throw new WrongLoginException("20", String.valueOf(login.length()));
            }
            if (password.length() > 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("20", String.valueOf(password.length()));
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
    }


}
