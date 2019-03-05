package com.ness;

public class TicTactoe {

    public static void main(String[] args) {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        Marker marker1 = Marker.X, marker2 = Marker.O;
        Player player1 = new RandomPlayer(marker1, "Player 1");
        Player player2 = new RandomPlayer(marker2, "Player 2");
        IO inputOutput = new ConsoleIO();
        Game tictactoe = new Game(tictactoeBoard, player1, player2, inputOutput);
        tictactoe.play();
    }
}
