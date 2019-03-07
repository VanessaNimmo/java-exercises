package com.ness;

class Game {

    InputOutput io;
    Calculator calculator;

    Game(InputOutput io, Calculator calculator) {
        this.io = io;
        this.calculator = calculator;
    }

    Board newBoard(boolean[][] initialLiveCells) {
        return new Board(initialLiveCells);
    }

    boolean[][] calculateNext(Board oldBoard) {
        return calculator.run(oldBoard.getLiveCells());
    }
}
