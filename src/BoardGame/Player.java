package BoardGame;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int money;
    private List<Lot> properties = new ArrayList<Lot>();
    private int fieldSpace;

    public Player(String name) {
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

    public void adjustMoney(int money) {
        this.money += money;
    }

    public void removeProperty(Lot property) {
        for (Lot lot : properties) {
            if (lot.equals(property)) {
                properties.remove(lot);
            }
        }
    }

    public void addProperty(Lot property) {
        properties.add(property);
    }

    public int getFieldSpace() {
        return fieldSpace;
    }

    public void setFieldSpace(int fieldSpace) {
        this.fieldSpace = fieldSpace;
    }
}
