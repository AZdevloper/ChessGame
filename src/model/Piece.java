package model;
import model.Exceptions.inValidMoveException;
import model.utils.Color;

public abstract class Piece {

    protected Color color ;
    protected Location location;
    protected String symbol;
    protected Board board;

    public Piece(Color color,Location loc,Board board, String symbol){
        this.board = board;
        this.color = color;
        location = loc;
        this.location.setPiece(this);
        this.symbol = symbol;
    }

    public Piece(){};
    public abstract void move(Location from,Location to) throws inValidMoveException;

}
