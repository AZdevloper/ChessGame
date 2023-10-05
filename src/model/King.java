package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

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

    public boolean isEmptyWay(Move move) {
        int colFrom = move.getFrom().getColumn();
        int colTo = move.getTo().getColumn();

        int rowFrom = move.getFrom().getRow();
        int rowTo = move.getTo().getRow();

        int colChang = Math.abs(colTo - colFrom);
        int rowChang = Math.abs(rowTo - rowFrom);

        if (colChang > 0) {
            // Rook is moving horizontally
            int step = colTo > colFrom ? 1 : -1; // Determine the direction of movement
            for (int i = colFrom + step; i != colTo; i += step) {
                if (board.locations[rowFrom][i].getPiece() != null) {
                    return false; // There is an obstacle in the way
                }
            }
        } else if (rowChang > 0) {
            // Rook is moving vertically
            int step = rowTo > rowFrom ? 1 : -1; // Determine the direction of movement
            for (int i = rowFrom + step; i != rowTo; i += step) {
                if (board.locations[i][colFrom].getPiece() != null) {
                    return false; // There is an obstacle in the way
                }
            }
        }

        // If no obstacles are encountered, the path is empty
        return true;
    }
}
