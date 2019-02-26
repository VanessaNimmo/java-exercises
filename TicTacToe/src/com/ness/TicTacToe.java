package com.ness;

public class TicTacToe {

    public static void main(String[] args) {
        int boardSize = 3;
        Board tictactoe = new Board(boardSize);
        // Since game now takes a board object, it could take anything that implements a board interface. You can figure out what the board interface needs to expose by writing the game class, and anything you need when you do this is a public method of the board interface. Anything else the board does in pursuit of this is a private method.
        Game newGame = new Game(tictactoe);
        newGame.play();
    }
}
