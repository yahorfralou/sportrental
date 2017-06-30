package com.epam.javadev.sportsrental.dao.fs.reader.csv.impl;

import com.epam.javadev.sportsrental.dao.fs.reader.IFileReader;
import com.epam.javadev.sportsrental.dao.fs.reader.exception.EntityResolveException;
import com.epam.javadev.sportsrental.domain.AbstractSportEquipment;
import com.epam.javadev.sportsrental.domain.factory.SportEquipmentFactory;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * Created by Yahor_Fralou on 6/27/2017.
 */
public class CSVSportEquipmentResolver implements IFileReader.EntityResolver<AbstractSportEquipment> {
    private static final String CSV_DELIMITER = ",";
    private static final int COLUMN_TYPE = 0;

    @Override
    public AbstractSportEquipment convertLine(String valuesRow) throws EntityResolveException {
        if (valuesRow == null) {
            throw new EntityResolveException("Values for parsing are null");
        }

        String[] values = getValuesFromLine(valuesRow);

        return convertValuesToEntity(values);
    }

    private AbstractSportEquipment convertValuesToEntity(String[] values) throws EntityResolveException {
        String typeName = getEntityType(values);

        AbstractSportEquipment entity;
        try {
            AbstractSportEquipment.Builder builder = SportEquipmentFactory.getSportEquipmentBuilder(typeName);

            String[] valuesForEntity = prepareEntityValues(values);

            entity = builder.newObject()
                    .populate(valuesForEntity)
                    .build();
        } catch (Exception e) {
            throw new EntityResolveException(String.format(
                    "Cannot resolve entity type %s with given values %s", typeName, Arrays.toString(values)),
                    e);
        }

        return entity;
    }

    private String[] prepareEntityValues(String[] valuesRow) {
        String[] valuesForEntity = new String[valuesRow.length - 1];

        for (int i = 1; i < valuesRow.length; i++) {
            valuesForEntity[i - 1] = valuesRow[i];
        }

        return valuesForEntity;
    }

    @Nullable
    private String getEntityType(String[] values) {
        String typeName;
        if (values.length > COLUMN_TYPE) {
            typeName = values[COLUMN_TYPE];
        } else {
            typeName = null;
        }

        return typeName;
    }

    private String[] getValuesFromLine(@NotNull String valuesRow) {
        String[] values;

        values = valuesRow.split(CSV_DELIMITER);

        return values;
    }
}
