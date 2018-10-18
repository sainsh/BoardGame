package BoardGame;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int money;
    private List<Lot> properties = new ArrayList<Lot>();

    public Player(String name) {
        this.name = name;
        money = 10000;

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
}
