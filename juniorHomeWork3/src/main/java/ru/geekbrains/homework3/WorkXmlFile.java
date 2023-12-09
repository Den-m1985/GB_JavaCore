package ru.geekbrains.homework3;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class WorkXmlFile {
    String fileName;
    Student student;
    private final XmlMapper xmlMapper = new XmlMapper();

    public WorkXmlFile(String fileName, Student student) {
        this.fileName = fileName;
        this.student = student;
    }

    public void serializeToXmlFile() throws IOException {
        xmlMapper.writeValue(new File(fileName), student);
        System.out.println("Объект Student сериализован в xml.");
    }

    public Student deSerializeFromXmlFile() throws IOException {
        File file = new File(fileName);
        student = xmlMapper.readValue(file, Student.class);
        System.out.println("Объект Student десериализован из xml.");
        return student;
    }

}
