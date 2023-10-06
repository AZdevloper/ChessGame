package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

import static model.utils.MessageUtils.showMessage;

public class Pawn extends Piece {


   public boolean willCapture = false;

    public Pawn(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }

    public Pawn(){};
    public void moveTo(Move move) throws  inValidMoveException{
       if( isCaptureMove(move) ){
            willCapture = true;
        }
        try {
            if (isValidMove(move)) {

                board.movePiece(move,this);
                isAlreadyMoved = true;
                if (move.getTo().getRow() == 7 && move.getPiece().color == Color.BLACK ) {

                    board.transformPawnToQueen(this);
                }
            }
        } catch (inValidMoveException e) {
            showMessage("Invalid move: " + e.getMessage(),"error");
        }
    }

    private boolean isCaptureMove(Move move) {
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getColumn();

        int toRow = move.getTo().getRow();
        int toCol =  move.getTo().getColumn();

        int rowChang = toRow - fromRow;
        int colChang = toCol - fromCol;


        if(move.getTo().getPiece() == null){
            return false;
        }else {
            boolean toGoContainsEnemyPiece = !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color);
            return rowChang == 1 && (colChang == 1 || colChang == -1) && toGoContainsEnemyPiece;
        }
    }
    public boolean isValidMove(Move move) throws inValidMoveException{
      int fromRow = move.getFrom().getRow();
      int fromCol = move.getFrom().getColumn();
      int toRow = move.getTo().getRow();
      int toCol =  move.getTo().getColumn();

      int rowChang =Math.abs(toRow - fromRow);
      int colChang = Math.abs(toCol - fromCol);

      if (rowChang == 1 && colChang == 0){
        return true;

      }
      if(colChang == 1 && willCapture){
          return true;
      }
      if (rowChang == 2 && !isAlreadyMoved && colChang ==0  ){
          return true;
      }
        throw new inValidMoveException(inValidMoveException.PAWN);
    }
}
