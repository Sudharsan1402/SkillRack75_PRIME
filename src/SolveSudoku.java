import java.util.*;
class Slot {
    int r, c;
}
public class SolveSudoku {
    static final int R = 9, C = 9;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++)
                matrix[row][col] = in.nextInt();

        }

        if (solve(matrix)) {
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Not Solved");
        }
    }

    private static boolean solve(int[][] matrix) {
        Slot slot = getFreeSlot(matrix);
        if (slot == null) {
            return true;
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (canFillRow(matrix, slot, digit) && canFillCol(matrix, slot, digit) && canFillSubmatrix(matrix, slot, digit)) {
                matrix[slot.r][slot.c] = digit;
                if (solve(matrix)) {
                    return true;
                }
                matrix[slot.r][slot.c] = 0;
            }
        }
        return false;
    }

    private static Slot getFreeSlot(int[][] matrix) {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (matrix[row][col] == 0) {
                    Slot slot = new Slot();
                    slot.r = row;
                    slot.c = col;
                    return slot;
                }
            }
        }
        return null;
    }

    private static boolean canFillRow(int[][] matrix, Slot slot, int digit) {
        for (int col = 0; col < C; col++) {
            if (matrix[slot.r][col] == digit) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFillCol(int[][] matrix, Slot slot, int digit) {
        for (int row = 0; row < R; row++) {
            if (matrix[row][slot.c] == digit) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFillSubmatrix(int[][] matrix, Slot slot, int digit) {
        int startRow = (slot.r / 3) * 3;
        int startCol = (slot.c / 3) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (matrix[row][col] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}
