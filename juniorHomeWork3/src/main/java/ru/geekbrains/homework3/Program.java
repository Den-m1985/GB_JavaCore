package ru.geekbrains.homework3;


import java.io.*;

public class Program {
    public static final String fileNameBin = "student.bin";
    public static final String fileNameJson = "student.json";
    public static final String fileNameXml = "student.xml";

    /*
     * Задача 1
     Разработайте класс Student с полями
     String name,
     int age,
     transient double GPA (средний балл)

     Обеспечьте поддержку сериализации для этого класса.
     Создайте объект класса Student и инициализируйте его данными.
     Сериализуйте этот объект в файл.
     Десериализуйте объект обратно в программу из файла.
     Выведите все поля объекта, включая GPA, и обсудите,
     почему значение GPA не было сохранено/восстановлено.
     */
    public static void main(String[] args) throws IOException {
        Student student = new Student("Станислав", 37, 23.3);

        WorkBinFile workBinFile = new WorkBinFile(fileNameBin, student);
        workBinFile.serializeToBinFile();
        Student student2 = workBinFile.deSerializeFromBinFile();
        System.out.println(student2);
        System.out.println("GPA (должен быть null, так как transient): " + student2.getGPA());

        WorkJsonFile workJsonFile = new WorkJsonFile(fileNameJson, student);
        workJsonFile.serializeToJsonFile();
        Student student3 = workJsonFile.deSerializeFromJsonFile();
        System.out.println(student3);

        WorkXmlFile workXmlFile = new WorkXmlFile(fileNameXml, student);
        workXmlFile.serializeToXmlFile();
        Student student4 = workXmlFile.deSerializeFromXmlFile();
        System.out.println(student4);
    }

}
