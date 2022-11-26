package com.kraievskyi.lection.task2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kraievskyi.lection.task2.model.Fine;
import com.kraievskyi.lection.task2.model.TotalFines;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadWrite {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/task2/out/output.xml";
    private static final String INPUT_FILE_PATH = "src/main/resources/task2/input";

    public List<Fine> readFiles() {
        ObjectMapper jsonMapper = new ObjectMapper();
        Path dir = Paths.get(INPUT_FILE_PATH);
        BufferedReader bufferedReader;
        List<Fine> fineList = new ArrayList<>();
        Fine[] fineArray;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.json")) {
            for (Path p : stream) {
                bufferedReader = Files.newBufferedReader(p);
                fineArray = jsonMapper.readValue(bufferedReader, Fine[].class);
                Collections.addAll(fineList, fineArray);
            }
            return fineList;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public void writeFileToXml(TotalFines totalFines) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TotalFines.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(totalFines, new File(OUTPUT_FILE_PATH));
        } catch (JAXBException e) {
            throw new RuntimeException("Can't write data to xml", e);
        }
    }
}
