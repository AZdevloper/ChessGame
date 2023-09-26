package model;

import model.Board;
import model.Exceptions.inValidMoveException;

public class Main {

    public static void main(String[] args) throws inValidMoveException {

        // initialize new board
        Board board = new Board();
        board.init();
        //start playing
        Game game = new Game(board);
        game.play();
    }
}
