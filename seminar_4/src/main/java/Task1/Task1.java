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

    }

    public static boolean loginPasw(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean flag = false;
        if (login.length() > 20) {
            flag = true;

        } else {
            throw new WrongLoginException();
        }
        if (password.length() >= 20 && password.equals(confirmPassword)) {
            flag = true;
        } else {
            throw new WrongPasswordException();
        }
        return flag;
    }


}
