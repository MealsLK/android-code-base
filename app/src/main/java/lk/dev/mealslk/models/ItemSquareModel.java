package lk.dev.mealslk.models;

public class ItemSquareModel {

    private int image;
    private String title;
    public ItemSquareModel(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }

}
