package model;
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
        this.symbol = symbol;
    }

}
