package ru.geekbrains.homework3;

import java.io.*;

public class WorkBinFile {
    String fileName;
    Student student;


    public WorkBinFile(String fileName, Student student) {
        this.fileName = fileName;
        this.student = student;
    }

    public void serializeToBinFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован в bin.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Объект Student не сериализован в bin.");
        }
    }

    public Student deSerializeFromBinFile() {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован из bin.");
            return student;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Объект Student не десериализован из bin.");
        }
    }

}
