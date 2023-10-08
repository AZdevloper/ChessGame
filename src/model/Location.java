package model;

import model.Exceptions.inValidMoveException;
import model.Exceptions.invalidStringOrderException;

public class Location {
    private int row;
    private int column;
    public static String defaultSymbol = " ❚ ";
    public static String defaultSymbol1 = "⌧ , ❚ ,";
    private Piece piece;

    public Location(String loc) throws  invalidStringOrderException{
        //System.out.println("loc : "+loc);
    char columnChar = loc.charAt(0);
    char rowChar = loc.charAt(1);

    int test = rowChar ;
    //System.out.println(rowChar - '0');
        if(( rowChar - '0' < 1 ) || ( rowChar - '0' > 8)  ){ //validating it's a number and in [1-8] rang , and not a letter;
            throw new invalidStringOrderException(invalidStringOrderException.ROW);
        }
        if (columnChar - 'a' < 0 || columnChar - 'a' > 7  ){
            throw new invalidStringOrderException(invalidStringOrderException.COLUMN);
        }
    row = rowChar - '0'; // Integer.parseInt() rowChar - 48; if rowChar = 7 then : 55 - 48 = 7
    row = 8-row;
    column = columnChar - 'a';


}
    public Location(int r, int c) {
        row = r;
        column = c;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece){
        this.piece = piece;
    }
    public void setRow(int row){
        this.row = row;
    }
    public int getRow(){
        return this.row;
    }
    public void setColumn(int col){
        this.column = col;
    }
    public int getColumn(){
        return this.column;
    }
}
