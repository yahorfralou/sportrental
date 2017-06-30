package com.epam.javadev.sportsrental.dao.fs.reader;

import com.epam.javadev.sportsrental.dao.fs.reader.exception.EntityResolveException;

import java.io.IOException;

/**
 * Created by Yahor_Fralou on 6/23/2017.
 */
public interface IFileReader<T> {
    void read(String filePath) throws IOException, EntityResolveException;

    void setListener(ReadListener<T> listener);

    void setEntityResolver(EntityResolver<T> resolver);

    interface ReadListener<T> {
        void onNextObject(T obj);
    }

    interface EntityResolver<T> {
        T convertLine(String s) throws EntityResolveException;
    }
}
