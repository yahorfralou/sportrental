package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Bat extends AbstractSportEquipment {
    private int length;
    private float weight;

    public Bat() {
    }

    public Bat(String title, int price, Category category, int length, float weight) {
        super(title, price, category);
        this.length = length;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length + ", weight=" + weight;
    }
}
