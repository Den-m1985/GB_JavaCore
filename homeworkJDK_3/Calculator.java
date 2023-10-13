
public class Calculator {


    public static <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        }
    }

    public static <T extends Number> T multiply(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        } else {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        }
    }

    public static <T extends Number> T subtract(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        } else {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        }
    }

    public static <T extends Number> double divide(T num1, T num2) {
        double result = num1.doubleValue() / num2.doubleValue();
        if (num1 instanceof Integer && num2 instanceof Integer && result == Math.floor(result)) {
            return (int) result;
        } else {
            return result;
        }
    }

    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

}
