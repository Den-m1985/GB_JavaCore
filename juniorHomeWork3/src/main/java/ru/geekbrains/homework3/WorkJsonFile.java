package ru.geekbrains.homework3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

public class WorkJsonFile {
    String fileName;
    Student student;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WorkJsonFile(String fileName, Student student) {
        this.fileName = fileName;
        this.student = student;
    }

    public void serializeToJsonFile() throws IOException {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(fileName), student);
        System.out.println("Объект Student сериализован в json.");
    }

    public Student deSerializeFromJsonFile() throws IOException {
        File file = new File(fileName);
        student = objectMapper.readValue(file, Student.class);
        System.out.println("Объект Student десериализован из json.");
        return student;
    }

}
