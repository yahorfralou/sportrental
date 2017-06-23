package com.epam.javadev.sportsrental.dao.fs.cache.impl;

import com.epam.javadev.sportsrental.dao.fs.cache.IShop;
import com.epam.javadev.sportsrental.domain.AbstractSportEquipment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yahor_Fralou on 6/23/2017.
 */
public class SimpleShop implements IShop {
    private static final int INIT_PROD_NUMBER = 1;

    private Map<AbstractSportEquipment, Integer> products
            = new HashMap<>();

    // TODO make a singleton

    void addEquipment(AbstractSportEquipment equip) {
        if (products.containsKey(equip)) {
            // TODO increment number
        } else {
            // TODO add a product
        }

        A a = new A();
        int c= a.b;
    }

    private static class A {
        private int b;
    }
}
