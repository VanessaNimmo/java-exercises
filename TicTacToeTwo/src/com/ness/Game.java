package com.ness;

class Game {

    Board board;
    private Player player1, player2;

    Game(Board tictactoeBoard, Player player1, Player player2) {
        this.board = tictactoeBoard;
        this.player1 = player1;
        this.player2 = player2;
    }

    void play() {
        // Welcome players to the game
        System.out.println("Welcome to TicTacToe!\n");
        // Explain what the game is?

        boolean changePlayerToken = true;
        boolean endGame = false;
        boolean markerPlaced = false;
        Player player;
        int markerPlacement;

        do {
            if(changePlayerToken) {
                player = this.player1;
            } else {
                player = this.player2;
            }
            // Print the board - should this be a separate method to represent the state of the board to anything outside the system?
            System.out.println(this.board.toString());
            // Get first move from player
            // Validate that move - keep asking for a move until you get a valid one
            do {
                markerPlacement = player.choosePosition(this.board.getSize());
                // Place that move on the board - only if that part of the board is empty
                if(this.board.squareIsAvailable(markerPlacement)) {
                    this.board.placeMarker(player.getMarker(), markerPlacement);
                    markerPlaced = true;
                }
            } while (!markerPlaced);

            // Check if someone has won
            if (this.gameIsWon()) endGame=true;
            // Alternate between player 1 and player 2 in this loop
            changePlayerToken = !changePlayerToken;
        } while (!this.board.isFull() && !endGame);
            // IF board is full and no one has won, print out draw message and set finished = true

            // IF someone has won print out the win message and set finished = true OR do some sort of break thing

        // After game is done, exit the program
    }

    private boolean gameIsWon() {
        // check this.board for if the game has been won
        return true;
    }
}
