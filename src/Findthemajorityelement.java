import java.util.*;
public class Findthemajorityelement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int counter = 1, majority = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] == majority) {
                counter++;
            } else {
                counter--;
                if (counter == 0) {
                    majority = arr[i];
                    counter = 1;
                }
            }
        }

        if (counter > 0) {
            int actual = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == majority) {
                    actual++;
                }
            }

            if (actual > N / 2) {
                System.out.print(majority);
                return;
            }
        }

        System.out.print("No Majority Element");

    }
}
