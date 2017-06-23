package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Shirt extends AbstractSportEquipment {
    private int size;
    private String teamName;

    public Shirt() {
    }

    public Shirt(String title, int price, Category category, int size, String teamName) {
        super(title, price, category);
        this.size = size;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", size=" + size + ", teamName=" + teamName;
    }
}
