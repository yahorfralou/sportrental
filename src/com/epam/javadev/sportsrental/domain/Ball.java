package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Ball extends AbstractSportEquipment {
    private String sportName;
    private int size;

    public Ball() {
    }

    public Ball(String title, int price, Category category, String sportName, int size) {
        super(title, price, category);
        this.sportName = sportName;
        this.size = size;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", sportName=" + sportName + ", size=" + size;
    }
}
