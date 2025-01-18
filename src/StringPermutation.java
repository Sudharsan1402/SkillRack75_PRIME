import java.util.*;
public class StringPermutation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char[] str = input.toCharArray();
        int len = str.length;

        int swapIndex = 0;
        for (int i = 0; i < len; i++) {
            permute(str, len, swapIndex, i);
        }

    }

    private static void permute(char[] str, int len, int swapIndex, int index) {
        if (swapIndex == len - 1) {
            System.out.println(String.valueOf(str));
            return;
        }

        swap(str, swapIndex, index);
        for (int i = swapIndex + 1; i < len; i++) {
            permute(str, len, swapIndex + 1, i);
        }
        swap(str, swapIndex, index);
    }

    private static void swap(char[] str, int x, int y) {
        char temp = str[x];
        str[x] = str[y];
        str[y] = temp;
    }
}
