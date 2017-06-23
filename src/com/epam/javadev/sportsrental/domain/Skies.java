package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Skies extends AbstractSportEquipment {
    private int length;

    public Skies() {

    }

    public Skies(String title, int price, Category category, int length) {
        super(title, price, category);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length;
    }

}
