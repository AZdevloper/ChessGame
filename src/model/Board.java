package model;
import model.Exceptions.inValidMoveException;
import model.utils.Color;
import java.util.Scanner;

public class Board {

    public  Location[][] locations;

    public  void movePiece(Location from, Location to){

        locations[to.getRow()][to.getColumn()].setPiece(getPieceToMove(from));
        locations[from.getRow()][from.getColumn()].setPiece(null);


    }
    public void movePieceToLocation(Location from, Location to) throws inValidMoveException {
        if (isPawn(from.getPiece()) ){
            Pawn  pawn = new Pawn();
            pawn.move(from, to);
        }
    }
    public Piece getPieceToMove(Location from){
        return locations[from.getRow()][from.getColumn()].getPiece();
    }

    public boolean isPawn(Piece piece){
       return piece.symbol.equals(" ♙") || piece.symbol.equals(" ♟");
    }
    public Board(){
        locations = new Location[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                locations[i][j] = new Location(i, j);
            }
        }
        //whiteCaptured = new ArrayList<>();
        //blackCaptured = new ArrayList<>();
        //isKingCaptured = false;
      }
    public void init() {
        // BLACK
        new Rook(Color.BLACK, locations[0][0], this," ♖");
        new Rook(Color.BLACK, locations[0][7], this," ♖");
        new Knight(Color.BLACK, locations[0][1], this," ♘");
        new Knight(Color.BLACK, locations[0][6], this," ♘");
        new Bishop(Color.BLACK, locations[0][2], this," ♗");
        new Bishop(Color.BLACK, locations[0][5], this," ♗");
        new Queen(Color.BLACK, locations[0][3], this," ♕");
        new King(Color.BLACK, locations[0][4], this," ♔");
        for (int i = 0; i < 8; i++) {
            new Pawn(Color.BLACK, locations[1][i], this," ♙");
        }

        // WHITE
        new Rook(Color.WHITE, locations[7][0], this, " ♜");
        new Rook(Color.WHITE, locations[7][7], this, " ♜");
        new Knight(Color.WHITE, locations[7][1], this, " ♞");
        new Knight(Color.WHITE, locations[7][6], this, " ♞");
        new Bishop(Color.WHITE, locations[7][2], this, " ♝");
        new Bishop(Color.WHITE, locations[7][5], this, " ♝");
        new Queen(Color.WHITE, locations[7][3], this, " ♛");
        new King(Color.WHITE, locations[7][4], this, " ♚");
        for (int i = 0; i < 8; i++) {
            new Pawn(Color.WHITE, locations[6][i], this, " ♟");
        }
    }
        @Override
    public String toString() {
            // Implement board display logic here.
            return "Chessboard"; // Replace with your logic.
        }
    public void move(String move) {
            // Implement the move logic here.
        }
    public Location getCurrentLocations(String move) {
        Location currentLocation = new Location(move);
        //System.out.println(" column : "+location.column + "row :" + location.row);
        return locations[currentLocation.getRow()][currentLocation.getColumn()];
    }
    public void printTheBoard() {

        System.out.println("     " + "  a  b  c d  e f g  h");
        for (int i = 0; i < 8; i++) {
            System.out.print("     " + (8 - i));
            for (int j = 0; j < 8; j++) {

                if (locations[i][j].getPiece() != null) {
                    System.out.print(locations[i][j].getPiece().symbol);
                } else {
                    System.out.print(Location.defaultSymbol);
                }
            }
           // System.out.print(8 - i);
            System.out.println();
        }
    }
    public boolean isGameOver() {
            // TODO: Implement this method.
            return false;
    }

    public String getWinner() {
            // TODO: Implement this method.
            return null;
    }
}
