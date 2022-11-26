package com.kraievskyi.lection.task1.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {
    private static final String INPUT_FILE_PATH = "src/main/resources/task1/input/input.xml";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/task1/out/output.xml";

    public String readFile() {
        File file = new File(INPUT_FILE_PATH);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public void fileWriter(String str) {
        File file = new File(OUTPUT_FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(str);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data into file", e);
        }
    }
}
