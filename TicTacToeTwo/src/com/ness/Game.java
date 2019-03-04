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

        boolean playerOnesTurn = true;
        Player player;

        do {
            player = choosePlayer(playerOnesTurn);
            takeTurn(player);

            if (gameIsWon()) {
                io.print(endGameMessage(true, player));
                break;
            }
            if (this.board.isFull()) {
                io.print(endGameMessage(false, player));
                break;
            }
            playerOnesTurn = !playerOnesTurn;

        } while (!this.board.isFull());
    }

    private void takeTurn(Player player) {
        printMoveInstructions(player);
        int markerPlacement = getNextMarker(player);
        this.board.placeMarker(player.getMarker(), markerPlacement);
        printPlacementMessage(markerPlacement);
    }

    private void printPlacementMessage(int markerPlacement) {
        String markerPlacementConfirmationMessage = String.format("You chose %d!%n", markerPlacement);
        io.print(markerPlacementConfirmationMessage);
        io.print(this.board.toString());
    }

    private void printMoveInstructions(Player player) {
        String getMoveMessage = String.format("%s, please choose a square: %n", player.getName());
        io.print(getMoveMessage);
        io.print(this.board.toString());
    }

    private String endGameMessage(boolean gameWon, Player winningPlayer) {
         return gameWon ? String.format("%s has won!%n", winningPlayer.getMarker()) : "Game was a draw.";
    }

    private Player choosePlayer(boolean changePlayerToken) {
        return changePlayerToken ? this.player1 : this.player2;
    }

    private int getNextMarker(Player player) {
        boolean markerValid = false;
        int markerPlacement = 0;
        do {
//            markerPlacement = io.getNextMove(1, 9, this.board.toString());
           markerPlacement = player.choosePosition(this.board.getSize());
           markerValid = checkMarkerValidity(player, markerPlacement);
        } while (!markerValid);
        return markerPlacement;
    }

    private boolean checkMarkerValidity(Player player, int markerPlacement) {
        if(isSquareAvailable(markerPlacement)) {
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

    private boolean gameIsWon() { return !this.board.markerHasWon().equals("N"); }
}