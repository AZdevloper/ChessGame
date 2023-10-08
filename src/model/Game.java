package model;

import model.Exceptions.inValidMoveException;
import model.Exceptions.invalidStringOrderException;
import model.utils.Color;

import java.util.Scanner;

import static model.utils.MessageUtils.showMessage;

public class Game {

    public  Color nextPlayer = Color.BLACK;
    public Board board;
    public  boolean isGameOver = false;
   // public  boolean isBlackTurn = true;
    public Scanner sc = new Scanner(System.in);

    public Game(Board board) {
        super();
        this.board = board;
    }
    public void play()  {


        System.out.println("\nThis is the board of your chess game:\n");
        board.printTheBoard();
        //  printHelp();


        while (!isGameOver) {
          //  if(board.isKingCaptured == true)
            //{
             //   break;
            //}

            if (nextPlayer == Color.BLACK) {
                System.out.print("\n Black plays. Please insert your move: ");

            } else {
                System.out.print("\n White plays. Please insert your move: ");

            }

            String order= sc.nextLine();
            try{
                Move move = handelMove(order);
                Piece piece = move.getPiece();

                if(piece.color == nextPlayer ){
                    try {
                        board.movePieceToLocation(move);
                        geveTurnToNextPlayer();
                        board.printTheBoard();
                    } catch (inValidMoveException e) {
                        showMessage("Invalid move: " + e.getMessage(),"error");
                    }
                }else{
                    showMessage(" not your turn !","error");
                    continue;}
            }catch (invalidStringOrderException e){
                showMessage(invalidStringOrderException.ROW,"error");
            }


        }

    }
    public Move  handelMove(String order ) throws invalidStringOrderException {
        Location from = board.getCurrentLocations(order.substring(0,2));
        Location to = board.getCurrentLocations(order.substring(2,4));

        Piece piece =  from.getPiece();

        return  new Move(piece, from, to);
    }

    public  void geveTurnToNextPlayer(){
        if (nextPlayer == Color.BLACK) {
            nextPlayer = Color.WHITE ;
        } else {
            nextPlayer = Color.BLACK ;
        }
    }

}
