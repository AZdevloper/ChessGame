package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;
import model.utils.Move;

import static model.utils.MessageUtils.showMessage;

public class Queen  extends Piece{
    public Queen(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }
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

        boolean isValidMoveForRook = (colChang > 0 && rowChang == 0 ) || ( rowChang > 0 && colChang == 0);
        boolean isValidMoveForBishop = (colChang == rowChang );
        boolean isValidMoveForKing  =  ((colChang == 1 || rowChang == 1) && (colChang == 0 || rowChang == 0) );

        if (( isValidMoveForBishop || isValidMoveForRook || isValidMoveForKing ) &&   istoGoEmpty ){
            return true;
        }else if (!istoGoEmpty){

            boolean toGoContainsEnemyPiece = !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color);
            boolean isMyPiece = !toGoContainsEnemyPiece;

            if (toGoContainsEnemyPiece){
                return true;

            }else if(isMyPiece) {
                throw new inValidMoveException(inValidMoveException.BISHOP);
            }
        }
        throw new inValidMoveException(inValidMoveException.BISHOP);



    }
}
