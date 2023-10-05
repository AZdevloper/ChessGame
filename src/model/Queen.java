package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

import java.io.FileReader;

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

//        int colFrom = move.getFrom().getColumn();
//        int colTo = move.getTo().getColumn();
//
//        int rowFrom = move.getFrom().getRow();
//        int rowTo = move.getTo().getRow();

//        int colChang = Math.abs(colTo -colFrom);
//        int rowChang = Math.abs(rowTo -rowFrom);

//        boolean istoGoEmpty = move.getTo().getPiece() == null;
        boolean isEmptyWay = isEmptyWay(move);

//        boolean isValidMoveForRook = (colChang > 0 && rowChang == 0 ) || ( rowChang > 0 && colChang == 0);
//        boolean isValidMoveForBishop = (colChang == rowChang );
//        boolean isValidMoveForKing  =  ((colChang == 1 || rowChang == 1) && (colChang == 0 || rowChang == 0) );

        if (  isEmptyWay ){
            if(move.getTo().getPiece() == null || !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color))
                return true;
            else
                throw new inValidMoveException(inValidMoveException.QUEEN);
        }else
            throw new inValidMoveException(inValidMoveException.QUEEN);
    }
    public boolean isEmptyWay(Move move) {
        int colFrom = move.getFrom().getColumn();
        int colTo = move.getTo().getColumn();
        int rowFrom = move.getFrom().getRow();
        int rowTo = move.getTo().getRow();

        int colChange = Math.abs(colTo - colFrom);
        int rowChange = Math.abs(rowTo - rowFrom);

        if (isMovingHorizontally(colChange, rowChange) || isMovingVertically(colChange, rowChange) || isMovingDiagonally(colChange, rowChange)) {
            int colStep = Integer.compare(colTo, colFrom);
            int rowStep = Integer.compare(rowTo, rowFrom);

            int currentCol = colFrom + colStep;
            int currentRow = rowFrom + rowStep;

            while (currentCol != colTo || currentRow != rowTo) {
                if (board.locations[currentRow][currentCol].getPiece() != null) {
                    return false; // There is an obstacle in the way
                }
                currentCol += colStep;
                currentRow += rowStep;
            }
        } else {
            // Not a valid move for a Queen
            return false;
        }

        // If no obstacles are encountered, the path is empty
        return true;
    }

    private boolean isMovingHorizontally(int colChange, int rowChange) {
        return colChange > 0 && rowChange == 0;
    }

    private boolean isMovingVertically(int colChange, int rowChange) {
        return colChange == 0 && rowChange > 0;
    }

    private boolean isMovingDiagonally(int colChange, int rowChange) {
        return colChange == rowChange;
    }

}
