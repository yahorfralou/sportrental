package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Cap extends AbstractSportEquipment {
    public Cap() {
    }

    public Cap(String title, int price, Category category) {
        super(title, price, category);
    }
}
