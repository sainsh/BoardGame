package BoardGame;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Field> playBoard = new ArrayList<Field>(); //the board itself
    private double fieldType;

    public Board(int boardSize) {   //when a board is made, create random fields of Lots and SpecialFields

        for (int i = 0; i < boardSize; i++) {   // how many is determined by boardsize

            fieldType = Math.random();
            if (fieldType < 0.5) {  // creates a Lot
                playBoard.add(new Lot(i, Integer.toString(i), (int) (Math.random() * 8000 + 1), Integer.toString((int)( Math.random() * 8.0))));

            } else {    //creates a SpecialField
                playBoard.add(new SpecialField(i, Integer.toString(i), (int) (Math.random() * 4000 - 2000), Integer.toString(i)));

            }

        }


    }

    public Field currentField(int index) {

        return playBoard.get(index);    // returns what is on a place on the board
    }
}
