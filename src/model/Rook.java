package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;
import model.utils.Move;

import static model.utils.MessageUtils.showMessage;

public class Rook  extends Piece{

    public Rook(Color color, Location loc, Board board, String symbol){
        super(color,loc,board,symbol);
    }
    public Rook(){};
    @Override
    public  void moveTo(Move move) {
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

        if ((colChang > 0 && rowChang == 0 ) || ( rowChang > 0 && colChang == 0) &&   istoGoEmpty ){

            if (colChang > rowChang) {
                if( colTo > checkPieceWay(move) ){
                    throw new inValidMoveException(inValidMoveException.ROOK);
                }
            }else{
                if( rowTo > checkPieceWay(move) ){
                    throw new inValidMoveException(inValidMoveException.ROOK);
                }
            }

            return true;

        }else if (!istoGoEmpty){

            boolean toGoContainsEnemyPiece = !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color);
            boolean isMyPiece = !toGoContainsEnemyPiece;

            if (toGoContainsEnemyPiece){
                return true;

            }else if(isMyPiece) {
                throw new inValidMoveException(inValidMoveException.ROOK);
            }
        }
        throw new inValidMoveException(inValidMoveException.ROOK);



    }
    public int checkPieceWay(Move move) {
        int colFrom = move.getFrom().getColumn();
        int colTo = move.getTo().getColumn();

        int rowFrom = move.getFrom().getRow();
        int rowTo = move.getTo().getRow();

        int colChang = Math.abs(colTo - colFrom);
        int rowChang = Math.abs(rowTo - rowFrom);

        if (colChang > rowChang) {

            // rowFrom+1 to eliminate him self
            for (int i=colChang+1 ; i < rowTo ; i++){
                if( board.locations[rowFrom][i] == null ){
                    continue;
                }else return i;
            }
        } else {
            // rowFrom+1 to eliminate him self
            for (int i=rowFrom+1 ; i < rowTo ; i++){
                if( board.locations[i][colChang] == null ){
                    continue;
                }else return i;
            }
        }
        return  0;

    }
}
