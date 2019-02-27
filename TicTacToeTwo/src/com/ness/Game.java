package com.ness;

class Game {

    Board board;
    private Player player1, player2;
    private int count = 0;

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
        boolean markerPlaced;
        Player player;
        Player winningPlayer = player1;
        int markerPlacement;
        String playerName;

        do {
            if(changePlayerToken) {
                player = this.player1;
                playerName = "Player 1";
            } else {
                player = this.player2;
                playerName = "Player 2";
            }
            // Print the board - should this be a separate method to represent the state of the board to anything outside the system?
            System.out.println(String.format("%s, please choose a square:", playerName));
            System.out.println(this.board.toString());
            // Get first move from player
            // Validate that move - keep asking for a move until you get a valid one
            do {
                markerPlaced = false;
                markerPlacement = player.choosePosition(this.board.getSize());
                // Place that move on the board - only if that part of the board is empty
                if(this.board.squareIsAvailable(markerPlacement)) {
                    this.board.placeMarker(player.getMarker(), markerPlacement);
                    markerPlaced = true;
                    System.out.println(String.format("You chose %d!", markerPlacement));
                    System.out.println(this.board.toString());
                } else {
                    System.out.println(String.format("%s, please choose an available square: ", playerName));
                    System.out.println(this.board.toString());
                }
            } while (!markerPlaced);

            // Check if someone has won
            if (this.gameIsWon()) {
                endGame=true;
                winningPlayer = player;
            }
            // Alternate between player 1 and player 2 in this loop
            changePlayerToken = !changePlayerToken;
        } while (!this.board.isFull() && !endGame);
            // IF someone has won print out the win message
            // IF board is full and no one has won, print out draw message
            if(endGame) {
                System.out.println(this.board.toString());
                System.out.println(String.format("%s has won!", winningPlayer.getMarker()));
            } else {
                System.out.println("Game was a draw.");
            }
        // After game is done, exit the program
    }

    private boolean gameIsWon() {
        // check this.board for if the game has been won
        String winningMarker = this.board.markerHasWon();
        if (winningMarker.equals("N")) {
            return false;
        } else {
            return true;
        }
//        count++;
//        if (count<12) {
//            return false;
//        }
//        return true;
    }
}
