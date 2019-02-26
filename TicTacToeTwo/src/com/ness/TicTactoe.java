package com.ness;

public class TicTactoe {

    public static void main(String[] args) {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        char marker1 = 'X', marker2 = 'O';
        Player player1 = new Player(marker1);
        Player player2 = new Player(marker2);
        Game tictactoe = new Game(tictactoeBoard, player1, player2);
        tictactoe.play();
    }
}
