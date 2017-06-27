package com.epam.javadev.sportsrental.dao.fs.reader.csv.impl;

import com.epam.javadev.sportsrental.dao.fs.reader.IFileReader;
import com.epam.javadev.sportsrental.dao.fs.reader.exception.EntityResolveException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader<T> implements IFileReader {
    private ReadListener<T> listener;
    private EntityResolver<T> resolver;
    private boolean skipOnError;

    @Override
    public void read(String filePath) throws IOException, EntityResolveException {
        File file = openFile(filePath);

        try (FileReader fileReader = new FileReader(file)) {
            String nextLine = ""; // TODO this is a stub

            processLine(nextLine);
        }
    }

    protected void processLine(String nextLine) throws EntityResolveException {
        if (resolver != null) {
            T entity;
            try {
                entity = resolver.convertLine(nextLine);
            } catch (EntityResolveException e) {
                if (!skipOnError) {
                    throw e;
                }
                entity = null;
            }

            notifyListeners(entity);
        }
    }

    private void notifyListeners(T entity) {
        if (listener != null && entity != null) {
            listener.onNextObject(entity);
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