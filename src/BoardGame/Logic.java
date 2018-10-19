package BoardGame;

import java.util.*;

public class Logic {

    Scanner in = new Scanner(System.in);

    private int numberOfPlayers = 0;

    private List<Player> players = new ArrayList<Player>();

    private boolean gameRunning = true;

    private int roundCounter = 1;

    private Dice dice = new Dice();
    private int diceRoll;

    private Board board;
    private int boardSize;


    public Logic() {

    }

    public void run() {

        setup();

        while (gameRunning) {
            System.out.printf("Round number %d start \n", roundCounter);
            round();


            roundCounter++;
        }

        end();
    }


    public void setup() {
        System.out.println("Welcome to My Board Game!!\n");

        System.out.print("How many players are going to play today? ");
        numberOfPlayers = in.nextInt();
        while (numberOfPlayers < 2) {

            System.out.println("You need 2 or more players to play this game. \n");
            System.out.print("how many players are going to play today?");
            numberOfPlayers = in.nextInt();

        }

        for (int i = 0; i < numberOfPlayers; i++) { // make new players

            System.out.printf("player %d\'s name: ", i + 1);

            players.add(new Player(in.next()));


        }

        System.out.println("How big should the board be? ");
        boardSize = in.nextInt();
        board = new Board(boardSize);


    }

    public void round() {

        for (Player player : players) {
            System.out.printf("%s\'s turn\n", player.getName());

            move(player);

            if (roundCounter == 300) {
                gameRunning = false;
            }

        }

    }

    public void move(Player player) {
        diceRoll = dice.rollDice();
        System.out.printf("you rolled : %d \n", diceRoll);
        if (player.getFieldSpace() + diceRoll < boardSize) {
            player.setFieldSpace(player.getFieldSpace() + diceRoll);
        } else {
            player.setFieldSpace(player.getFieldSpace() + diceRoll - boardSize);
        }
        if(board.currentField(player.getFieldSpace()).getClass() == SpecialField.class)
        System.out.printf("You landed on %s which is: %s\n", board.currentField(player.getFieldSpace()).getName(), ((SpecialField)board.currentField(player.getFieldSpace())).getText());


    }

    public void end() {

        System.out.println("End of game");
        for (Player player : players) {
            System.out.printf("%s has %d\n", player.getName(), player.getMoney());
        }

    }
}
