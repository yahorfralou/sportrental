package com.epam.javadev.sportsrental.dao.fs.reader.csv.impl;

import com.epam.javadev.sportsrental.dao.fs.reader.IFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Yahor_Fralou on 6/23/2017.
 */
public class CSVReader implements IFileReader {
    private ReadListener listener;
    private EntityResolver resolver;

    @Override
    public void read(String filePath) throws IOException {
        File file = openFile(filePath);

        try (FileReader fileReader = new FileReader(file)) {

            String line = "";

            listener.onNextObject(resolver.convertLine(line));
        }
    }

    private File openFile(String filePath) {
        File dataFile = new File(filePath);
        // TODO check file

        return dataFile;
    }

    @Override
    public void setListener(ReadListener listener) {
        this.listener = listener;
    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {

    }
}