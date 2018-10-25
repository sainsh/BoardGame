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

    private Player winner;


    public Logic() {

    }

    public void run() {

        setup();        //sets up the game before starting

        while (gameRunning) {   //the game it self
            System.out.printf("Round number %d start \n", roundCounter);
            round();        //round method for the actual rounds


            roundCounter++;     //counts rounds, since the game could run forever there's a time limit
        }

        end(); // end of game method
    }


    public void setup() {
        System.out.println("Welcome to My Board Game!!\n");

        System.out.print("How many players are going to play today? ");
        numberOfPlayers = in.nextInt();  // inputs how many players are playing
        while (numberOfPlayers < 2) { //if less than 2 then prompts again for a new number of players

            System.out.println("You need 2 or more players to play this game. \n");
            System.out.print("how many players are going to play today?");
            numberOfPlayers = in.nextInt();

        }

        for (int i = 0; i < numberOfPlayers; i++) { // make new players

            System.out.printf("player %d\'s name: ", i + 1);

            players.add(new Player(in.next())); // creates numberOfPlayers new players


        }

        System.out.println("How big should the board be? ");
        boardSize = in.nextInt();   //inputs the size of the board
        board = new Board(boardSize); //creates a board of specified size


    }

    public void round() {       // round method

        for (Player player : players) {     // each players has a turn
            System.out.printf("%s\'s turn\n", player.getName());    // specified by their name

            move(player);       // first thing they do is move
            System.out.println();
            if (player.getMoney() <= 0) {   //if a players loses all money the game ends
                gameRunning = false;
            }
            if (roundCounter == 300) {      //if 300 rounds are played the game ends
                gameRunning = false;
            }

        }

    }

    public void move(Player player) {       //move method, happens for each player 1 pr. round
        diceRoll = dice.rollDice();     //rolls dice
        System.out.printf("you rolled : %d \n", diceRoll);
        if (player.getFieldSpace() + diceRoll <= boardSize) {       //determines if the roll moves playing within board space
            player.setFieldSpace(player.getFieldSpace() + diceRoll);
        } else {    // if not then the players rounded the board and starts over at 1
            while (player.getFieldSpace() > boardSize) {    // on smaller boards it's possible to rounds the board multiple times
                player.setFieldSpace(player.getFieldSpace() + diceRoll - boardSize);
            }

        }
        if (board.currentField(player.getFieldSpace() - 1).getClass() == SpecialField.class) {  // the player lands on a Lot

            landOnSpecialField(player, (SpecialField) board.currentField(player.getFieldSpace() - 1));

        } else if (board.currentField(player.getFieldSpace() - 1).getClass() == Lot.class) {    // the player lands on a special field

            landOnLot(player, (Lot) board.currentField(player.getFieldSpace() - 1));
        }


    }

    public void landOnLot(Player player, Lot lot) {
        System.out.printf("You landed on %s which is: %s\n", lot.getName(), lot.getColor());

        if (lot.isOwned()) {    //checks if lot is owned by someone

            if (player == lot.getOwner()) { // if you are the owner you can buy houses for the lot

                System.out.printf("You are the owner of this lot\n");

                if (lot.getNumberOfHouses() < 5) {  //if there are less than 5 houses on the lot

                    System.out.println("do you want to buy houses for this lot? y/n");

                    if (in.next().equals("y")) {

                        buyHouses(player, lot); // goes to buy house method

                    }
                }

            } else { //if the lot is owned by someone else, the players pays the owner the value of the lot

                System.out.printf("This lot is owned by %s\n", lot.getOwner().getName());
                System.out.printf("pay %d to %s", lot.getValue(), lot.getOwner().getName());
                player.adjustMoney(-lot.getValue());
                lot.getOwner().adjustMoney(lot.getValue());
                System.out.println();
            }

        } else { // if the lot is not owned the player can buy the lot
            System.out.printf("This lot is not owned\n do you want to buy it at %d? y/n ", lot.getValue());
            if (in.next().equals("y")) {
                lot.buy(player); // set owner as player and sets owned as true
                player.adjustMoney(-lot.getValue()); // the players pays for the lot
            }
            System.out.println();
        }
    }

    public void landOnSpecialField(Player player, SpecialField field) { //player lands of special field

        System.out.printf("You landed on %s which is: %s\n", field.getName(), field.getText()); // prints a statement from the SpecialField
        //todo some SpecialFields needs actions, like adjust player money or move player to other fields

    }

    public void buyHouses(Player player, Lot lot) {

        System.out.printf("you have %d and each house costs %d\n",player.getMoney(),lot.getHousePrice()); // displays player's money and the price of a single house

        System.out.printf("how many? 1-%s", 5 - lot.getNumberOfHouses());   //displays number of houses can be bought

        int numberOfHouses = in.nextInt();

        if (numberOfHouses <= 5 - lot.getNumberOfHouses()) {    //if input is less or equal to available houses
            lot.setNumberOfHouses(lot.getNumberOfHouses() + numberOfHouses); //houses are place on lot
            player.adjustMoney(-(int) (lot.getHousePrice() * numberOfHouses)); // players pays for houses

        } else {
            System.out.println("no houses bought");
        }
    }

    public void end() {

        System.out.println("End of game");
        for (Player player : players) {
            System.out.printf("%s has %d\n", player.getName(), player.getMoney());  //displays what money each player has

        }
        winner = players.get(0);
        for (Player p : players) {  // finds winner by who has the most money
            if (p.getMoney() > winner.getMoney()) {
                winner = p;
            }

        }
        System.out.printf("The winner is %s", winner.getName()); // displays winner


    }
}
