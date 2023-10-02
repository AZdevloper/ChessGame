package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;
import model.utils.Move;

import static model.utils.MessageUtils.showMessage;

public class King extends  Piece{
    public King(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }

    public King(){};
    @Override
    public void moveTo(Move move) throws inValidMoveException {
        try {
            if (isValidMove(move)) {
                board.movePiece(move,this);

            }
        } catch (inValidMoveException e) {
            showMessage("Invalid move: " + e.getMessage(),"error");
        }
    }

    public boolean isValidMove(Move move) throws inValidMoveException{

        int colFrom = move.getFrom().getColumn();
        int colTo = move.getTo().getColumn();

        int rowFrom = move.getFrom().getRow();
        int rowTo = move.getTo().getRow();

        int colChang = Math.abs(colTo -colFrom);
        int rowChang = Math.abs(rowTo -rowFrom);

        boolean istoGoEmpty = move.getTo().getPiece() == null;

        if (   ( (colChang == 1 || rowChang == 1) && (colChang == 0 || rowChang == 0) ) &&   istoGoEmpty  ){
            return true;
        }else if (!istoGoEmpty){

            boolean toGoContainsEnemyPiece = !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color);
            boolean isMyPiece = !toGoContainsEnemyPiece;

            if (toGoContainsEnemyPiece){
                return true;

            }else if(isMyPiece) {
                throw new inValidMoveException(inValidMoveException.KING);
            }
        }
        throw new inValidMoveException(inValidMoveException.KING);



    }
}
