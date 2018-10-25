package BoardGame;

import java.util.Random;

public class Dice {

    private Random rand = new Random();

    public Dice() {

    }

    public int rollDice() { // returns a roll of 2 6sided dice

        return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
    }
}
