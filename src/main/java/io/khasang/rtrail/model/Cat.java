package io.khasang.rtrail.model;

public class Cat {
    private int id;
    private String name;
    private String description;
    private int colorId;

    public Cat() {
    }

    public Cat(int id, String name, String description, int colorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.colorId = colorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", colorId=" + colorId +
                '}';
    }
}
