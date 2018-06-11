package io.khasang.rtrail.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private String name;
    private String link;
    private boolean active;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private List<Menu> subMenu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) &&
                Objects.equals(link, menu.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, link);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", active=" + active +
                ", selected=" + selected +
                ", subMenu=" + subMenu +
                '}';
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Menu(String name, String link) {

        this(name, link, false, false);
    }

    public Menu(String name, String link, boolean selected, boolean active) {
        this.name = name;
        this.link = link;
        this.selected = selected;
        this.active = active;
        this.subMenu = new LinkedList<>();
    }

    public void addSubMenu(Menu menu) {
        subMenu.add(menu);
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

}
