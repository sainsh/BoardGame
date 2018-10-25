package BoardGame;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int money;
    private List<Lot> properties = new ArrayList<Lot>();  //list of lots owned
    private int fieldSpace;

    public Player(String name) {    //creates a new player with name given and a stardard amount of money and a starting place
        this.name = name;
        this.money = 10000;
        this.fieldSpace = 1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void adjustMoney(int money) {        // changes the amount of money a player has, up or down
        this.money += money;
    }

    public void removeProperty(Lot property) {  //sell a Lot
        for (Lot lot : properties) {
            if (lot.equals(property)) {
                properties.remove(lot);
            }
        }
    }

    public void addProperty(Lot property) {
        properties.add(property);
    }   // adds a lot to list of lots

    public int getFieldSpace() {    // return where a players is on the board
        return fieldSpace;
    }

    public void setFieldSpace(int fieldSpace) { //moves the player
        this.fieldSpace = fieldSpace;
    }
}
