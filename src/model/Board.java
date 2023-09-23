package model;

import java.util.Scanner;

public class Board {


        private static final String[]  LETTERS = {"0","a", "b", " c", " d"," e", " f", "j", "h"};
        private static final String[] NUMBERS = {"0","1", "2", "3", "4", "5", "6", "7", "8"};
        private static final String[] WHITE_PIECES = {"♙", "♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"};
        private static final String[] BLACK_PIECES = {"♟", "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
        private static final String[] COLORS = {"White", "Black"};
        private String[][] board;
        private String currentPlayer;
      public Board(){
              board = new String[10][10];
              currentPlayer = COLORS[0];

              // Initialize the board with the starting positions of the pieces.
              board[0][0] = " ";
              for (int i = 0; i <= 9; i++) {
                  if ( i >= 1 && i!=9 ){
                      board[i][0] = NUMBERS[i];
                  }
                      for (int j = 1; j <= 8; j++) {
                              if (i == 0  ) {
                                  board[i][j] = LETTERS[j];
                                      //board[i][j] = WHITE_PIECES[0];

                              } else if( i==1 ){
                                  board[i][j] = BLACK_PIECES[j];

                              } else if (i == 2 ){
                                  board[i][j] = WHITE_PIECES[0];
                              }
                              else if (i==7) {
                                      board[i][j] = BLACK_PIECES[0];

                              } else if (i == 8  ) {
                                      //board[i][j] = LETTERS[j];
                                      board[i][j] = WHITE_PIECES[j];

                              }
                              else {
                                      board[i][j] = "⬛";
                              }
                      }
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

        public void play() {
                Scanner scanner = new Scanner(System.in);
                printBoard();

                while (!isGameOver()) {
                        System.out.println("It is " + currentPlayer + "'s turn.");
                        System.out.println("Enter your move (e.g. e2e4): ");

                        String move = scanner.nextLine();
                        handelMove(move);

                        // Switch players.
                        currentPlayer = currentPlayer.equals(COLORS[0]) ? COLORS[1] : COLORS[0];
                }

                System.out.println("The game is over!");
                System.out.println("The winner is " + getWinner() + "!");
        }

        public void handelMove(String move){

        }
        public void printBoard() {
                for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if ("⬛".equals(board[i][j]))
                                System.out.print(board[i][j]);
                            else System.out.print(board[i][j]+" ");
                        }
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
