import java.util.*;
public class DeleteTVChannels {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        List<Integer> channels = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            channels.add(i);
        }

        int deleteIndex = -1;
        while (channels.size() > 1) {
            deleteIndex += K;
            if(deleteIndex >= channels.size()){
                deleteIndex %= channels.size();
            }
            channels.remove(deleteIndex);
            deleteIndex--;
        }

        System.out.println(channels.get(0));

    }
}
