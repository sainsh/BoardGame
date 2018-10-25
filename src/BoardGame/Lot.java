package BoardGame;

public class Lot extends Field {

    private int value;
    private String color;   //is what chain of Lots this lot is part of , currently not used
    private boolean isOwned;
    private int numberOfHouses;
    private Player owner;
    private double housePrice;

    public Lot(int number, String name, int value, String color) {  // a lot is a field a player can own
        super(number, name);
        this.value = value;
        this.color = color;
        this.isOwned = false;
        this.numberOfHouses = 0;
        this.owner = null;
        this.housePrice = value*0.9;

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

    public void buy(Player owner) { //sets player as owner and isOwned as true
        this.isOwned = true;
        setOwner(owner);
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) { //changes value of lot by how many houses are on this lot
        this.numberOfHouses = numberOfHouses;
        setValue(this.value * (this.numberOfHouses + 1));
    }

    public Player getOwner() {
        return owner;
    }

    private void setOwner(Player owner) {
        this.owner = owner;
    }

    public void sell(){     // frees up the lot so another player can buy the lot
        this.owner = null;
        this.isOwned=false;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }
}
