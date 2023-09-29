package model;
import model.Exceptions.inValidMoveException;
import model.utils.Color;
import model.utils.Move;

public abstract class Piece {

    protected Color color ;
    protected Location location;
    protected String symbol;
    protected Board board;

    public Piece(Color color,Location loc,Board board, String symbol){
        this.color = color;
        location = loc;
        this.location.setPiece(this);
        this.symbol = symbol;
        this.board = board;
    }

    public Piece(){};
    public abstract void moveTo(Move move) throws inValidMoveException;

}
