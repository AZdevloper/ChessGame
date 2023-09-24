package model;

public class Location {
    public int row;
    public int column;
    public static String defaultSymbol = "⬛";
    public Piece piece;

    public Location(String loc){
        System.out.println("loc : "+loc);
    char columnChar = loc.charAt(0);
    char rowChar = loc.charAt(1);

    //System.out.println(rowChar - '0');

    row = rowChar - '0';
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
    public  String toString(){
        return "⬛";
    }
}
