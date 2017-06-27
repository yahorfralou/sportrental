package com.epam.javadev.sportsrental.dao.fs.impl;

import com.epam.javadev.sportsrental.dao.IDataInitializer;
import com.epam.javadev.sportsrental.dao.fs.reader.IFileReader;
import com.epam.javadev.sportsrental.domain.AbstractSportEquipment;

/**
 * Created by Yahor_Fralou on 6/23/2017.
 */
public class FileDataInitializer implements IDataInitializer,
        IFileReader.ReadListener<AbstractSportEquipment>{
    private static final String SPORT_DATA_FILE_NAME = "data.csv";

    @Override
    public void initData() {
        IFileReader fileReader;
        //fileReader.read(SPORT_DATA_FILE_NAME);
    }


    @Override
    public void onNextObject(AbstractSportEquipment obj) {

    }
}
