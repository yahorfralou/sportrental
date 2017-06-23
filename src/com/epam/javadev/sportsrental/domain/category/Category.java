package com.epam.javadev.sportsrental.domain.category;

import java.util.Objects;

/**
 * Created by Yahor_Fralou on 6/21/2017.
 */
public class Category {
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        boolean isEqual;

        if (obj instanceof Category) {
            Category category = (Category) obj;
            isEqual = this.name != null && this.name.equalsIgnoreCase(category.getName());
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
