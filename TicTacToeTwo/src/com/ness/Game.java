package com.ness;

class Game {

    Board board;
    private Player player1, player2;
    private IO player1io, player2io;

    Game(Board tictactoeBoard, Player player1, Player player2, IO player1io, IO player2io) {
        this.board = tictactoeBoard;
        this.player1 = player1;
        this.player2 = player2;
        this.player1io = player1io;
        this.player2io = player2io;
    }

    void play() {
        player1io.print("Welcome to Tic Tac Toe!");

        boolean playerOnesTurn = true;
        Player player;
        IO io;

        do {
            player = choosePlayer(playerOnesTurn);
            io = chooseIO(playerOnesTurn);

            takeTurn(player, io);

            if (this.board.gameIsWon()) {
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

    private IO chooseIO(boolean changePlayerToken) {
        return changePlayerToken ? this.player1io : this.player2io;
    }

    private void takeTurn(Player player, IO io) {
        printMoveInstructions(player, io);
        int markerPlacement = getNextMarker(player, io);
        this.board.placeMarker(player.getMarker(), markerPlacement);
        printPlacementMessage(markerPlacement, io);
    }

    private void printPlacementMessage(int markerPlacement, IO io) {
        String markerPlacementConfirmationMessage = String.format("You chose %d!%n", markerPlacement);
        io.print(markerPlacementConfirmationMessage);
        io.print(this.board.toString());
    }

    private void printMoveInstructions(Player player, IO io) {
        String getMoveMessage = String.format("%s, please choose a square, or enter q to quit: %n", player.getName());
        io.print(getMoveMessage);
        io.print(this.board.toString());
    }

    private String endGameMessage(boolean gameWon, Player winningPlayer) {
         return gameWon ? String.format("%s has won!%n", winningPlayer.getMarker()) : "Game was a draw.";
    }

    private Player choosePlayer(boolean changePlayerToken) {
        return changePlayerToken ? this.player1 : this.player2;
    }

    private int getNextMarker(Player player, IO io) {
        boolean markerValid = false;
        int markerPlacement = 0;
        do {
            markerPlacement = io.getNextMove(1, 9, this.board.toString());
//           markerPlacement = player.choosePosition(this.board.getSize());
           markerValid = checkMarkerValidity(player, markerPlacement, io);
        } while (!markerValid);
        return markerPlacement;
    }

    private boolean checkMarkerValidity(Player player, int markerPlacement, IO io) {
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
}