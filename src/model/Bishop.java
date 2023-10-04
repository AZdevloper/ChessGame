package model;

import model.Exceptions.inValidMoveException;
import model.utils.Color;

import static model.utils.MessageUtils.showMessage;

public class Bishop extends Piece {
    public Bishop(Color color, Location loc, Board board,String symbol){
        super(color,loc,board,symbol);
    }
    public Bishop(){};
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
        boolean isEmptyWay = isEmptyWay(move);

        if ((colChang == rowChang )  && isEmptyWay){
            if(move.getTo().getPiece() == null || !move.getFrom().getPiece().color.equals(move.getTo().getPiece().color))
                return true;
            else
                throw new inValidMoveException(inValidMoveException.ROOK);
        }else
            throw new inValidMoveException(inValidMoveException.BISHOP);
    }

    public boolean isEmptyWay(Move move) {
        int colFrom = move.getFrom().getColumn();
        int colTo = move.getTo().getColumn();
        int rowFrom = move.getFrom().getRow();
        int rowTo = move.getTo().getRow();

        int colChange = Math.abs(colTo - colFrom);
        int rowChange = Math.abs(rowTo - rowFrom);

        int colStep = colTo > colFrom ? 1 : -1; // Determine the column step direction
        int rowStep = rowTo > rowFrom ? 1 : -1; // Determine the row step direction

        // Check if the Bishop is moving diagonally (colChange must be equal to rowChange)
        if (colChange == rowChange) {
            int currentCol = colFrom + colStep;
            int currentRow = rowFrom + rowStep;

            while (currentCol != colTo && currentRow != rowTo) {
                if (board.locations[currentRow][currentCol].getPiece() != null) {
                    return false; // There is an obstacle in the way
                }
                currentCol += colStep;
                currentRow += rowStep;
            }
        } else {
            // If colChange is not equal to rowChange, it's not a valid diagonal move for a Bishop
            return false;
        }
        // If no obstacles are encountered, the path is empty
        return true;
    }

}
