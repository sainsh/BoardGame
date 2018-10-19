package BoardGame;

import java.util.Random;

public class Dice {

    private Random rand = new Random();

    public Dice() {

    }

    public int rollDice() {

        return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
    }
}
