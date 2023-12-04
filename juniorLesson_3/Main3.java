import java.io.*;
import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(Character.getName(i));
//        }
//        serialObj(list, "ser");

        ArrayList<String> list2 = null;
        list2 = (ArrayList<String>) deSerialObj("ser");
        serialObj(list2, "ser");
        System.out.println(list2);

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

}
