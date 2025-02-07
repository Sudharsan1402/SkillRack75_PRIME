import java.util.*;
public class BinaryMatrixRowDuplicates {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int row = in.nextInt();
        int col = in.nextInt();

        Set<String> set = new HashSet<>();
        boolean valid = true;

        for (int r = 0; r < row; r++) {
            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < col; c++) {
                int x = in.nextInt();
                sb.append("" + x);
            }

            if (set.contains(sb.toString())) {
                System.out.print((r + 1) + " ");
                valid = false; // Set valid to false when a duplicate is found
            } else { // Add the string to the set only if it's not a duplicate
                set.add(sb.toString());
            }
        }

        System.out.print(valid ? -1 : "");

    }
}
