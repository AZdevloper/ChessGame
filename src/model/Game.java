package model;

import java.util.Scanner;

public class Game {
    public Board board;
    public  boolean isGameOver = false;
    public  boolean isBlackTurn = true;
    public Scanner sc = new Scanner(System.in);

    public Game(Board board) {
        //super();
        this.board = board;
       // gameInAction = true;
        //turn = 0;
        //validMoves = new ArrayList<>();

    }
    public void play() {


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

            String move= sc.nextLine();
            handelMove(move);
        }

    }
    public void handelMove(String move){
        // export from and to
        Location from = board.getLocations(move.substring(0,2));
        //Location to = board.getLocations(move.substring(2,4));




    }
}
