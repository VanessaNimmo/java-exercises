package com.ness;

public class TicTactoe {

    public static void main(String[] args) {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        String marker1 = "X", marker2 = "O";
        Player player1 = new RandomPlayer(marker1, "Player 1");
        Player player2 = new RandomPlayer(marker2, "Player 2");
        Game tictactoe = new Game(tictactoeBoard, player1, player2);
        tictactoe.play();
    }
}
