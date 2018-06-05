package io.khasang.rtrail.model;

public class CatForJdbcInfo {
    private int id;
    private String name;
    private String description;
    private int color_id;

    public CatForJdbcInfo(int id, String name, String description, int color_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color_id = color_id;
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
        return color_id;
    }

    public void setColorId(int color_id) {
        this.color_id = color_id;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color_id=" + color_id +
                '}';
    }
}
