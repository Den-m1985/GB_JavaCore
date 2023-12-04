import java.io.*;

public class Main1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // создаем файл и записываем в него строку
        String str = "Ok";
        FileOutputStream fileOutputStream = new FileOutputStream("ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String s = (String) objectInputStream.readObject();
        System.out.println(s);
    }
}
