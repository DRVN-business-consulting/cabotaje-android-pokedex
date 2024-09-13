package dev.jay.pokedex.models;

import androidx.annotation.NonNull;

import java.util.List;

public class Pokemon {
    private int id;
    private Image image;
    private String name;
    private String[] types;
    private int[] typeIcons;
    private String[] abilities;

    public Pokemon(int id, Image image, String name, String[] types, int[] typeIcons, String[] abilities) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.types = types;
        this.typeIcons = typeIcons;
        this.abilities = abilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public int[] getTypeIcons() {
        return typeIcons;
    }

    public void setTypeIcons(int[] typeIcons) {
        this.typeIcons = typeIcons;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    @NonNull
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", image=" + image +
                ", name='" + name + '\'' +
                ", types=" + types +
                ", abilities=" + abilities +
                '}';
    }
}
