package com.ness;

public class TicTactoe {

    public static void main(String[] args) {
        int boardSize = 3;
        WinChecker checker = new WinChecker();
        Board tictactoeBoard = new TicTacToeBoard(boardSize, checker);
        Marker marker1 = Marker.X, marker2 = Marker.O;
        Player player1 = new Player(marker1, "Player 1");
        Player player2 = new Player(marker2, "Player 2");
        IO player1io = new ConsoleHumanPlayerIO();
        IO player2io = new ConsoleRandomPlayerIO();
        Game tictactoe = new Game(tictactoeBoard, player1, player2, player1io, player2io);
        tictactoe.play();
    }
}
