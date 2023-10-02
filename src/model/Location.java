package model;

public class Location {
    private int row;
    private int column;
    public static String defaultSymbol = " ⬛";
    public static String defaultSymbol1 = "\" ";
    private Piece piece;

    public Location(String loc){
        //System.out.println("loc : "+loc);
    char columnChar = loc.charAt(0);
    char rowChar = loc.charAt(1);

    //System.out.println(rowChar - '0');

    row = rowChar - '0'; // Integer.parseInt() rowChar - 48;
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
