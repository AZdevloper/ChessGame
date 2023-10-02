package model;

import model.Exceptions.inValidMoveException;
import model.utils.Move;

import java.util.Scanner;

public class Game {
    public Board board;
    public  boolean isGameOver = false;
    public  boolean isBlackTurn = true;
    public Scanner sc = new Scanner(System.in);

    public Game(Board board) {
        super();
        this.board = board;
       // gameInAction = true;
        //turn = 0;
        //validMoves = new ArrayList<>();

    }
    public void play() throws inValidMoveException {


        System.out.println("\nThis is the board of your chess game:\n");
        board.printTheBoard();
      //  printHelp();

        while (!isGameOver) {
          //  if(board.isKingCaptured == true)
            //{
             //   break;
            //}

            if (isBlackTurn) {
                System.out.print("\nBlack plays. Please insert your move: ");
                isBlackTurn = false;
            } else {
                System.out.print("\nWhite plays. Please insert your move: ");
                isBlackTurn = true;
            }

            String order= sc.nextLine();
            handelMove(order);
        }

    }
    public void handelMove(String order ) throws inValidMoveException {
        // export from and to
        Location from = board.getCurrentLocations(order.substring(0,2));
        //System.out.println(" row :"+from.getRow()+ "column : "+from.getColumn());
        Location to = board.getCurrentLocations(order.substring(2,4));

        Piece piece =  from.getPiece();
        Move move = new Move(piece, from, to);

        //Location test = new Location(8,4);
//        Piece pieceToMove = from.getPiece();
//        System.out.println("pieceToMove : " + pieceToMove.symbol);
//        System.out.println("pieceToMove location : " +"row : " +pieceToMove.location.getRow()+"col : " + pieceToMove.location.getColumn());

        board.movePieceToLocation(move);

        //System.out.println("pieceToMove location : " +"row : " +pieceToMove.location.getRow()+"col : " + pieceToMove.location.getColumn());
        //Piece movedPiece = to.getPiece();
//         System.out.println("to piece symole " +movedPiece.symbol);
        board.printTheBoard();

    }
}
