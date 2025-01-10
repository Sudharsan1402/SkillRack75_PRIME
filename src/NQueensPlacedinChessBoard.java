import java.util.*;
public class NQueensPlacedinChessBoard {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        byte[][] board = new byte[N][N];
        boolean[] rowsAttacked = new boolean[N];
        boolean[] colsAttacked = new boolean[N];
        boolean[] southwestAttacked = new boolean[2 * N - 1];
        boolean[] northwestAttacked = new boolean[2 * N - 1];
        boolean[] queensPlaced = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = in.nextByte();

                if (board[row][col] == 1) {
                    rowsAttacked[row] = true;
                    colsAttacked[col] = true;
                    southwestAttacked[col - row + N - 1] = true;
                    northwestAttacked[col + row] = true;
                    queensPlaced[row] = true;
                }
            }
        }

        if (placeQueen(board, N, 0, rowsAttacked, colsAttacked, southwestAttacked, northwestAttacked, queensPlaced)) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not Possible");
        }
    }

    private static boolean placeQueen(byte[][] board, int N, int row, boolean[] rowsAttacked, boolean[] colsAttacked, boolean[] southwestAttacked, boolean[] northwestAttacked, boolean[] queensPlaced) {
        if (row == N) {
            return true;
        }

        if (queensPlaced[row]) {
            return placeQueen(board, N, row + 1, rowsAttacked, colsAttacked, southwestAttacked, northwestAttacked, queensPlaced);
        }

        for (int col = 0; col < N; col++) {
            if (!rowsAttacked[row] && !colsAttacked[col] && !southwestAttacked[col - row + N - 1] && !northwestAttacked[col + row]) {
                rowsAttacked[row] = true;
                colsAttacked[col] = true;
                southwestAttacked[col - row + N - 1] = true;
                northwestAttacked[col + row] = true;
                board[row][col] = 1;
                queensPlaced[row] = true;

                if (placeQueen(board, N, row + 1, rowsAttacked, colsAttacked, southwestAttacked, northwestAttacked, queensPlaced)) {
                    return true;
                }

                queensPlaced[row] = false;
                rowsAttacked[row] = false;
                colsAttacked[col] = false;
                southwestAttacked[col - row + N - 1] = false;
                northwestAttacked[col + row] = false;
                board[row][col] = 0;
            }
        }

        return false;
    }
}
