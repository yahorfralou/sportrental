package com.epam.javadev.sportsrental.domain;

import com.epam.javadev.sportsrental.domain.category.Category;

import java.util.Objects;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public abstract class AbstractSportEquipment {
    private String title;
    private int price;
    private Category category;

    public AbstractSportEquipment() {
    }

    public AbstractSportEquipment(String title, int price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        boolean isEqual;
        if (obj instanceof AbstractSportEquipment) {
            AbstractSportEquipment sportEq = (AbstractSportEquipment) obj;
            isEqual = this.title != null && this.title.equalsIgnoreCase(sportEq.title);
        } else {
            isEqual = false;
        }

        return isEqual;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category;
    }
}
