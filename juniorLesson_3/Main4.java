import java.io.*;

public class Main4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //MyFCs myFCs = new MyFCs("Ivanov","Ivan","Petrovich");
        //serialObj(myFCs, "ser");

        MyFCs myFCs1 = (MyFCs) deSerialObj("ser");
        System.out.println(myFCs1);

    }

    public static void serialObj(Object obj, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    static class MyFCs implements Serializable {
        public String lastName;
        public  String firstName;
        public String patronymic;

        public MyFCs(String lastName, String firstName, String patronymic) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return "NyFCs{" +
                    "lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", patronymic='" + patronymic + '\'' +
                    '}';
        }
    }
}
