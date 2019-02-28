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
        boolean gameWon = false;
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
            // Interface outputs - asking player to choose a thing, showing player the board
            System.out.format("%s, please choose a square: %n", playerName);
            // Validate that move - keep asking for a move until you get a valid one
            do {
                markerPlaced = false;
                markerPlacement = player.choosePosition(this.board.getSize());
                // Place that move on the board - only if that part of the board is empty

                // Should the player deal with an IO interface or not?
                // Also could make this a helper method in this class just to get it out of this big flow and make it easier to read
                if(this.board.squareIsAvailable(markerPlacement)) {
                    this.board.placeMarker(player.getMarker(), markerPlacement);
                    markerPlaced = true;
                    System.out.format("You chose %d!%n", markerPlacement);
                    System.out.println(this.board);
                } else {
                    System.out.format("%s, please choose an available square: %n", playerName);
                    System.out.println(this.board);
                }
            } while (!markerPlaced);

            if (this.gameIsWon()) {
                gameWon=true;
                winningPlayer = player;
            }
            changePlayerToken = !changePlayerToken;
        } while (!this.board.isFull() && !gameWon);
            if(gameWon) {
                System.out.format("%s has won!%n", winningPlayer.getMarker());
            } else {
                System.out.println("Game was a draw.");
            }
        // After game is done, exit the program
    }

    private boolean gameIsWon() {
        // check this.board for if the game has been won
        String winningMarker = this.board.markerHasWon();
        return !winningMarker.equals("N");
    }
}
