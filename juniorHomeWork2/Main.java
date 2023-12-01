import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    /*
    Создайте абстрактный класс "Animal" с полями "name" и "age".
    Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
    Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    Выведите на экран информацию о каждом объекте.
    Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     */

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Animal> zoo = new FabricZoo(6).getZoo();

        for (Animal animal : zoo) {
            reflection(animal);
        }
    }


    public static void reflection(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class<?> clazz = obj.getClass();

        // Получаем список всех полей и их значение
        Field[] fields = clazz.getDeclaredFields();
        Field[] fieldsSuper = clazz.getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            System.out.println("Field: " + fieldName + "  Value = " + field.get(obj));
        }
        for (Field field : fieldsSuper) {
            String fieldName = field.getName();
            field.setAccessible(true);
            System.out.println("Field: " + fieldName + "  Value = " + field.get(obj));
        }

        // Получаем список всех конструкторов
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor: " + constructor.getName());
        }

        // Получаем список методов и что они делаеют.
        Method[] displayInfoMethod = obj.getClass().getDeclaredMethods();
        for (Method method : displayInfoMethod) {
            System.out.println("Method: \"" + method.getName() + "\" it do: " +method.invoke(obj));
        }
    }

}
