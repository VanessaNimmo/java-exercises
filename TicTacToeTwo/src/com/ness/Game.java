package com.ness;

class Game {

    Board board;
    private Player player1, player2;
    IO io;

    Game(Board tictactoeBoard, Player player1, Player player2, IO inputOutput) {
        this.board = tictactoeBoard;
        this.player1 = player1;
        this.player2 = player2;
        this.io = inputOutput;
    }

    void play() {
        io.printWelcomeMessage("Tic Tac Toe");

        boolean changePlayerToken = true;
        boolean gameWon = false;
        boolean markerPlaced;
        Player player;
        Player winningPlayer = player1;
        int markerPlacement;

        do {
            player = changePlayer(changePlayerToken);
            System.out.format("%s, please choose a square: %n", player.getName());
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
            if(gameWon) {
                System.out.format("%s has won!%n", winningPlayer.getMarker());
            } else {
                System.out.println("Game was a draw.");
            }
    }

    private Player changePlayer(boolean changePlayerToken) {
        return changePlayerToken ? this.player1: this.player2;
    }

    private boolean placeMarker(Player player, int markerPlacement) {
        if(this.isSquareAvailable(markerPlacement)) {
            this.board.placeMarker(player.getMarker(), markerPlacement);
            System.out.format("You chose %d!%n", markerPlacement);
            System.out.println(this.board);
            return true;
        } else {
            System.out.format("%s, please choose an available square: %n", player.getName());
            System.out.println(this.board);
        }
        return false;
    }

    private boolean isSquareAvailable(int markerPlacement) {
        return this.board.squareIsAvailable(markerPlacement);
    }

    private boolean gameIsWon() {
        String winningMarker = this.board.markerHasWon();
        return !winningMarker.equals("N");
    }
}
