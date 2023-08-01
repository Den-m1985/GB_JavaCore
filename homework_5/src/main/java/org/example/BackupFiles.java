package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public BackupFiles() {
        String sourceDirectory = "src/main/java/org/example"; // Путь к исходной директории
        String backupDirectory = "./backup"; // Путь к папке с резервными копиями

        try {
            File sourceDir = new File(sourceDirectory);

            // Проверяем, существует ли исходная директория
            if (!sourceDir.exists() || !sourceDir.isDirectory()) {
                System.out.println("Исходная директория не существует или не является директорией.");
                return;
            }

            // Создаем папку с резервными копиями, если она не существует
            File backupDir = new File(backupDirectory);
            if (!backupDir.exists()) {
                backupDir.mkdir();
                System.out.println("Создана директория для резервных копий: " + backupDir.getAbsolutePath());
                System.out.println(backupDir.getPath());
            }

            // Получаем список всех файлов в исходной директории
            File[] files = sourceDir.listFiles();

            // Копируем каждый файл в папку с резервными копиями
            for (File file : files) {
                if (file.isFile()) {
                    File destFile = new File(backupDir.getAbsolutePath() + "/" + file.getName());
                    Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Создана резервная копия файла: " + destFile.getAbsolutePath());
                }
            }

            System.out.println("Резервные копии всех файлов созданы успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании резервной копии файла: " + e.getMessage());
        }
    }

}
