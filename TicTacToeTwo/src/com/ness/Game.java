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

            printMoveInstructions(player, io);

            int nextMove = getNextMove(player, io);
            if (nextMove==0) {
                break;
            }

            this.board.placeMarker(player.getMarker(), nextMove);
            printPlacementMessage(nextMove, io);

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
        // print goodbye message as a test of end of game?
    }

    private Player choosePlayer(boolean changePlayerToken) {
        return changePlayerToken ? this.player1 : this.player2;
    }

    private IO chooseIO(boolean changePlayerToken) {
        return changePlayerToken ? this.player1io : this.player2io;
    }

    private void printMoveInstructions(Player player, IO io) {
        String getMoveMessage = String.format("%s, please choose a square, or enter q to quit: %n", player.getName());
        io.print(getMoveMessage);
        io.print(this.board.toString());
    }

    private void printPlacementMessage(int markerPlacement, IO io) {
        String markerPlacementConfirmationMessage = String.format("You chose %d!%nHere is the current board: ", markerPlacement);
        io.print(markerPlacementConfirmationMessage);
        io.print(this.board.toString());
    }

    private int getNextMove(Player player, IO io) {
        int markerPlacement = io.getNextMove(1, 9, this.board.toString());
        if (markerPlacement==0) {
            return markerPlacement;
        }
        if (!squareIsAvailable(markerPlacement)) {
            printNotAvailableErrorMessage(player, io);
            getNextMove(player, io);
        }
        return markerPlacement;
    }

    private boolean squareIsAvailable(int markerPlacement) {
        return this.board.squareIsAvailable(markerPlacement);
    }

    private void printNotAvailableErrorMessage(Player player, IO io) {
        String markerPlacementErrorMessage = String.format("That square is not available!%n%s, please choose an available square: %n", player.getName());
        io.print(markerPlacementErrorMessage);
        io.print(this.board.toString());
    }

    private String endGameMessage(boolean gameWon, Player winningPlayer) {
         return gameWon ? String.format("%s has won!%n", winningPlayer.getMarker()) : "Game was a draw.";
    }
}