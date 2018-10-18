package BoardGame;

public class Lot extends Field {

    private int value;
    private String color;
    private boolean isOwned;
    private int numberOfHouses;

    public Lot(int number, String name, int value, String color) {
        super(number, name);
        this.value = value;
        this.color = color;
        isOwned = false;
        numberOfHouses = 0;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
        setValue(this.value * (this.numberOfHouses + 1));
    }
}
