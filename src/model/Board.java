package model;
import model.Exceptions.inValidMoveException;
import model.utils.Color;
import static  model.utils.MessageUtils.showMessage;

public class Board {

    public  Location[][] locations;

    public  void movePiece( Move move,Piece  piece){
        locations[move.getTo().getRow()][move.getTo().getColumn()].setPiece(piece);
        piece.location = locations[move.getTo().getRow()][move.getTo().getColumn()];

        locations[move.getFrom().getRow()][move.getFrom().getColumn()].setPiece(null);
    }
    public void movePieceToLocation(Move move) throws inValidMoveException {
        Piece piece = move.getPiece();
        piece.moveTo(move);
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
            new Pawn(Color.BLACK, locations[3][i], this," ♙");
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
    public Location getCurrentLocations(String move) {
        Location currentLocation = new Location(move);
        //System.out.println(" column : "+location.column + "row :" + location.row);
        return locations[currentLocation.getRow()][currentLocation.getColumn()];
    }
    public void printTheBoard() {

        System.out.println("\n     " + "  a  b  c d  e f g  h");
        for (int i = 0; i < 8; i++) {
            System.out.print("     " + (8 - i));
            for (int j = 0; j < 8; j++) {

                if (locations[i][j].getPiece() != null) {
                    System.out.print(locations[i][j].getPiece().symbol);
                } else {
                    showMessage(Location.defaultSymbol,"success");
                }
            }
           // System.out.print(8 - i);
            if (i == 7) {
                System.out.print("");
            } else {
                System.out.println();


            }
        }
        System.out.println("\n     " + "  a  b  c d  e f g  h");
    }

    public void transformPawnToQueen(Pawn pawn) {

        Location pawnLocation = pawn.location ;

        String QueenSymbol = null;
        if (pawn.color == Color.BLACK)
            QueenSymbol = "♕" ;
        else if (pawn.color == Color.WHITE) {
            QueenSymbol= "♛";
        }

        Queen queen = new Queen(pawn.color, pawnLocation, this, QueenSymbol);

        locations[pawnLocation.getRow()][pawnLocation.getColumn()].setPiece(queen);
    }
}
