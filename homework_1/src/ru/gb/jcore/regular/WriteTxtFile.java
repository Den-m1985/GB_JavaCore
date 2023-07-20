package ru.gb.jcore.regular;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTxtFile {

    public WriteTxtFile(String downloadsPath, String time, String data) {
        try (FileWriter writer = new FileWriter(downloadsPath, true)) {
            writer.write("*******************" + time + "*************************" + "\n");
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
