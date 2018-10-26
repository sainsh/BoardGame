# BoardGame

This is a board game based on Monopoly. 
setup is first run. 
which prompts the user(s) for the number of players playing, then their names and then the size of the board, 
if less than 2 is input for number of players the user(s) are prompted again stating that 2 or more players are required. 
Then a board is made with the size specified by the user(s) and fields are auto-generated with 2 different types, Lots and Specialfields 
Then the game begins. Each player is given a turn where they move, dice i thrown moving the player to a new field, if the player's location
and the diceroll adds up to more than the board's size it loops around to the start. then a player lands on either a Lot or a SpecialField.
if a Lot then the the isOwned boolean is check, if false the player can buy the Lot, if true the player pays the lot's value to the owner.
If the current player is the owner, the player can choose to buy houses, upto 5 total is allowed on each lot, increasing the value of the 
Lot. If the player lands on a SpecialField a text is displayed describing the field. A set of things to happen to the player needs to be 
added to the SpecialField. After each player's turn their money is check to see if it's 0 or below, if so the game ends and the player with
the most money wins. If no player has won after round 300 the game ends and the player with the most money wins.
