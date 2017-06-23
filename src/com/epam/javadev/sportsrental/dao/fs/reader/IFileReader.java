package com.epam.javadev.sportsrental.dao.fs.reader;

import java.io.IOException;

/**
 * Created by Yahor_Fralou on 6/23/2017.
 */
public interface IFileReader {
    void read(String filePath) throws IOException;

    void setListener(ReadListener listener);

    void setEntityResolver(EntityResolver resolver);

    interface ReadListener<T> {
        void onNextObject(T obj);
    }

    interface EntityResolver<T> {
        T convertLine(String s);
    }
}
