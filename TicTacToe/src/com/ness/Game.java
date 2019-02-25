package com.ness;

class Game {

    Player player1, player2;
    Board tictactoe;

    Game(int boardSize) {
        this.tictactoe = new Board(boardSize);
        this.player1 = new Player('O');
        this.player2 = new Player('X');
    }

    void play() {
        // Alternate between players and take moves from them until either one of them wins or they draw
    }


}
