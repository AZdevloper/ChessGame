package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;
import model.utils.Move;

public class Queen  extends Piece{
    public Queen(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }
    @Override
    public void moveTo(Move move) throws inValidMoveException {

    }
}
