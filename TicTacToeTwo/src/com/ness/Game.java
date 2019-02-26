package com.ness;

class Game {



    void play() {
        // Welcome players to the game
        System.out.println("Welcome to TicTacToe!\n");
        // Explain what the game is?

        boolean changePlayerToken = true;
        do {
            if(changePlayerToken) {
                player = player1;
            } else {
                player = player2;
            }
            // Print the board
            board.print();
            // Get first move from player
            // Validate that move
            player.makeMove();
            // Place that move on the board if it is valid
            board.update();
            // Check if someone has won
            board.checkWinConditions();
            if (gameIsWon) endGame(player);
            // Check if the board is full
            board.checkFull();
            // Alternate between player 1 and player 2 in this loop
            changePlayerToken = !changePlayerToken;
        } while (!board.isFull);
            // IF board is full and no one has won, print out draw message and set finished = true

            // IF someone has won print out the win message and set finished = true OR do some sort of break thing
        private void endGame() {
            // print win message
            // end game
        }

        // After game is done, exit the program
    }
}
