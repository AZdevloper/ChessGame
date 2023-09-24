package model;

import model.Board;

public class Main {

    public static void main(String[] args) {

        // initialize new board
        Board board = new Board();
        board.init();
        //start playing
        Game game = new Game(board);
        game.play();
    }
}
