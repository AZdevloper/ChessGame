package model;
import model.Exceptions.inValidMoveException;
import model.utils.Color;

public abstract class Piece {

    protected Color color ;
    protected Location location;
    protected String symbol;
    protected Board board;
    protected boolean isAlreadyMoved = false;

    public Piece(Color color,Location loc,Board board, String symbol){
        this.color = color;
        location = loc;
        this.location.setPiece(this);
        this.symbol = symbol;
        this.board = board;
    }

    public Piece(){};
    public abstract void moveTo(Move move) throws inValidMoveException;
    public abstract boolean isValidMove(Move move) throws inValidMoveException;

}
