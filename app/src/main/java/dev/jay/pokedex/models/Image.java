package dev.jay.pokedex.models;

public class Image {
    private int thumbnail;
    private int hiRes;

    public Image(int thumbnail, int hiRes) {
        this.thumbnail = thumbnail;
        this.hiRes = hiRes;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getHiRes() {
        return hiRes;
    }

    public void setHiRes(int hiRes) {
        this.hiRes = hiRes;
    }

    @Override
    public String toString() {
        return "Image{" +
                "thumbnail=" + thumbnail +
                ", hiRes=" + hiRes +
                '}';
    }
}
