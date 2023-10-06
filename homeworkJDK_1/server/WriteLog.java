package server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {
    public String path;

    public WriteLog(String path) {
        this.path = path;
    }

    public void writeTxt(String data) {
        String str = new ReadLog(path).readTxtFile();
        String result = str + System.lineSeparator() + data;
        fileWriter(result);
    }


    public void fileWriter(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл.");
            throw new RuntimeException(e);
        }
    }

}
