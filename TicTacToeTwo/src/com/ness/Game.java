package com.ness;

class Game {

    Board board;
    private Player player1, player2;
    private IO io;

    Game(Board tictactoeBoard, Player player1, Player player2, IO inputOutput) {
        this.board = tictactoeBoard;
        this.player1 = player1;
        this.player2 = player2;
        this.io = inputOutput;
    }

    void play() {
        io.print("Welcome to Tic Tac Toe!");

        boolean changePlayerToken = true;
        boolean gameWon = false;
        boolean markerPlaced;
        Player player;
        Player winningPlayer = player1;
        int markerPlacement;

        do {
            player = changePlayer(changePlayerToken);
            String getMoveMessage = String.format("%s, please choose a square: %n", player.getName());
            io.print(getMoveMessage);
            io.print(this.board.toString());
            do {
                markerPlacement = player.choosePosition(this.board.getSize());
                markerPlaced = placeMarker(player, markerPlacement);
            } while (!markerPlaced);

            if (this.gameIsWon()) {
                gameWon=true;
                winningPlayer = player;
            }

            changePlayerToken = !changePlayerToken;

        } while (!this.board.isFull() && !gameWon);
        io.print(this.endGameMessage(gameWon, winningPlayer));
    }

    private String endGameMessage(boolean gameWon, Player winningPlayer) {
         return gameWon ? String.format("%s has won!%n", winningPlayer.getMarker()) : "Game was a draw.";
    }

    private Player changePlayer(boolean changePlayerToken) {
        return changePlayerToken ? this.player1 : this.player2;
    }

    private boolean placeMarker(Player player, int markerPlacement) {
        if(this.isSquareAvailable(markerPlacement)) {
            this.board.placeMarker(player.getMarker(), markerPlacement);
            String markerPlacementConfirmationMessage = String.format("You chose %d!%n", markerPlacement);
            io.print(markerPlacementConfirmationMessage);
            io.print(this.board.toString());
            return true;
        } else {
            String markerPlacementErrorMessage = String.format("%s, please choose an available square: %n", player.getName());
            io.print(markerPlacementErrorMessage);
            io.print(this.board.toString());
        }
        return false;
    }

    private boolean isSquareAvailable(int markerPlacement) {
        return this.board.squareIsAvailable(markerPlacement);
    }

    private boolean gameIsWon() {
        return !this.board.markerHasWon().equals("N");
    }
}