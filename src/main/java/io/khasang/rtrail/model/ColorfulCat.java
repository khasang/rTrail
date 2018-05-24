package io.khasang.rtrail.model;

import io.khasang.rtrail.model.Cat;

public class ColorfulCat extends Cat {
    private String color;

    ColorfulCat() {
        super();
    }

    public ColorfulCat(String color) {
        this.color = color;
    }

    public ColorfulCat(int id, String name, String description, int colorId, String color) {
        super(id, name, description, colorId);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + super.getId()+
                ", name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
