package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

import static model.utils.MessageUtils.showMessage;

public class Pawn extends Piece {


  // public boolean willCapture = false;

    public Pawn(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }

    public Pawn(){}
    @Override
    public void moveTo(Move move) throws  inValidMoveException{

            if (isValidMove(move)) {

                board.movePiece(move,this);
                isAlreadyMoved = true;
                if (move.getTo().getRow() == 7 && move.getPiece().color == Color.BLACK ) {

                    board.transformPawnToQueen(this);
                }
            }

    }

    private boolean isCaptureMove(Move move) {
        return move.getTo().getPiece() != null && !move.getPiece().color.equals(move.getTo().getPiece().color);
    }
    @Override
    public boolean isValidMove(Move move) throws inValidMoveException{

      boolean  isCaptureMove = isCaptureMove(move);

      int fromRow = move.getFrom().getRow();
      int fromCol = move.getFrom().getColumn();
      int toRow = move.getTo().getRow();
      int toCol =  move.getTo().getColumn();

      int rowChang =toRow - fromRow;
      int colChang = toCol - fromCol;

      boolean isBlack = isBlack(move.getPiece());
      boolean isWith = isWith(move.getPiece());

      if ( ( rowChang == 1 || (rowChang == 2 && !isAlreadyMoved ) ) && colChang == 0 && isBlack ){
        return move.getTo().getPiece() == null;

      }
      else if((colChang == 1 || colChang == -1 )&& isCaptureMove){
          return true;
      }
     else if ( ( rowChang == -1 || (rowChang == -2 && !isAlreadyMoved ) ) && colChang ==0 && isWith ){
          return move.getTo().getPiece() == null;
      }
        throw new inValidMoveException(inValidMoveException.PAWN);


    }

    public boolean isBlack(Piece piece){
        return piece.color == Color.BLACK;
    }

    public boolean isWith(Piece piece){
        return piece.color == Color.WHITE;
    }
}
