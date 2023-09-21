import java.util.Scanner;

public class ChessBoard {


        private static final char[] WHITE_PIECES = {'♙', '♖', '♘', '♗', '♕', '♔'};
        private static final char[] BLACK_PIECES = {'♟', '♜', '♞', '♝', '♛', '♚'};
        private static final String[] COLORS = {"White", "Black"};
        private char[][] board;
        private String currentPlayer;
      public ChessBoard(){
              board = new char[8][8];
              currentPlayer = COLORS[0];

              // Initialize the board with the starting positions of the pieces.
              for (int i = 0; i < 8; i++) {
                      for (int j = 0; j < 8; j++) {
                              if (i == 1 ) {
                                      board[i][j] = WHITE_PIECES[0];
                              } else if (i==6) {
                                      board[i][j] = BLACK_PIECES[0];
                              } else if (i == 0 || i == 7) {
                                      board[i][j] = PIECES[i / 7];
                              } else {
                                      board[i][j] = '-';
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

                while (!isGameOver()) {
                        printBoard();

                        System.out.println("It is " + currentPlayer + "'s turn.");
                        System.out.println("Enter your move (e.g. e2e4): ");

                        String move = scanner.nextLine();

                        // Validate the move.
                        // TODO: Implement this method.

                        // Make the move.
                        // TODO: Implement this method.

                        // Switch players.
                        currentPlayer = currentPlayer.equals(COLORS[0]) ? COLORS[1] : COLORS[0];
                }

                System.out.println("The game is over!");
                System.out.println("The winner is " + getWinner() + "!");
        }

        public void printBoard() {
                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                                System.out.print(board[i][j] + " ");
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
