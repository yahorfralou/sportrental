package com.epam.javadev.sportsrental.domain.factory;

import com.epam.javadev.sportsrental.domain.AbstractSportEquipment;
import com.epam.javadev.sportsrental.domain.Ball;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yahor_Fralou on 6/27/2017.
 */
public class SportEquipmentFactory {
    // TODO implement as singleton
    private static Map<EquipmentType, AbstractSportEquipment.Builder> builders;

    static {
        builders = new HashMap<>();
        builders.put(EquipmentType.BALL, new Ball.Builder());
    }

    @NotNull
    public static AbstractSportEquipment.Builder getSportEquipmentBuilder(String typeName) throws Exception {
        EquipmentType equipmentType;

        try {
            equipmentType = EquipmentType.valueOf(typeName);
        } catch (IllegalArgumentException e) {
            // TODO handle, throw custom exception
            throw new Exception("No such entity known: " + typeName);
        }
        AbstractSportEquipment.Builder builder = builders.get(equipmentType);
        if (builder == null) {
            throw new Exception("No such entity in Builders mapping:" + typeName);
        }
        return builder;
    }

    public enum EquipmentType {
        BALL, CAP, BAT, SHIRT, SKIES
    }
}
