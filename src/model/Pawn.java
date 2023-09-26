package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

public class Pawn extends Piece {

   public boolean isAlreadyMoved = true;

    public Pawn(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }

    public Pawn(){};
    public void move(Location from, Location to) throws  inValidMoveException{
        if (isValidMove(from, to)){
         new Board().movePiece(from,to);
        }
    }

    public boolean isValidMove(Location from,Location to) throws inValidMoveException{
        if (isAlreadyMoved){
            if (Math.abs(from.getColumn()- to.getColumn()) > 1){

                throw new inValidMoveException(inValidMoveException.PAWN);
            }

        }


    }
}
