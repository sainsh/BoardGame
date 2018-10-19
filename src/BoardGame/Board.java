package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Field> playBoard = new ArrayList<Field>();
    private double fieldType;

    public Board(int boardSize) {

        for (int i = 0; i < boardSize; i++) {

            fieldType = Math.random();
            if (fieldType < 0.5) {
                playBoard.add(new Lot(i, Integer.toString(i), (int) (Math.random() * 8000 + 1), Integer.toString((int)( Math.random() * 8.0))));

            } else {
                playBoard.add(new SpecialField(i, Integer.toString(i), (int) (Math.random() * 4000 - 2000), Integer.toString(i)));

            }

        }


    }

    public Field currentField(int index) {

        return playBoard.get(index);
    }
}
