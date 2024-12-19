import java.util.*;
public class SocialMediaLeader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int R = in.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= R; i++) {
            int follower = in.nextInt();
            int followedBy = in.nextInt();
            arr[follower]--;
            arr[followedBy]++;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == N - 1) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);

    }
}
