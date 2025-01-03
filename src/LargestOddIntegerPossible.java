import java.util.*;
public class LargestOddIntegerPossible {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long N = in.nextLong();

        long[] digits = new long[10];

        while (N != 0) {
            digits[(int) (Math.abs(N % 10))]++;
            N /= 10;
        }

        int unitDig = -1;

        for (int digit = 1; digit <= 9; digit += 2) {
            if (digits[digit] > 0) {
                unitDig = digit;
                digits[digit]--;
                break;
            }
        }

        if (unitDig == -1) {
            System.out.print("no");
            return;
        }

        int start = 1;
        for (int digit = 1; digit <= 9; digit++) {
            if (digits[digit] > 0) {
                start = 0;
                break;
            }
        }

        for (int digit = 9; digit > start; digit--) {
            while (digits[digit] > 0) {
                System.out.print(digit);
                digits[digit]--;
            }
        }

        System.out.print(unitDig);

    }
}
