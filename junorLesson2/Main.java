import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Car car = new Car();

        Class<?> car = Class.forName("Car");
        Constructor<?>[] constructor = car.getConstructors();
        //System.out.println(constructor);

        Object gaz = constructor[0].newInstance("GAZ");
        //System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int temp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, temp*2);
        //System.out.println(gaz);


        //Method[] methods = gaz.getClass().getMethods();
        Method[] methods = gaz.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

    }
}
