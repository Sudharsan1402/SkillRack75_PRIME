import java.util.*;
public class BrowsingCentreComputers {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String[] slot = in.nextLine().split("\\s+");
            start.add(toMins(slot[0]));
            end.add(toMins(slot[1]));
        }

        int computers = 0, stIndex = 0, endIndex = 0;
        Collections.sort(start);
        Collections.sort(end);

        while (stIndex < start.size() && endIndex < end.size()) {
            int currReq = Math.abs(stIndex - endIndex) + 1;
            if (currReq > computers) {
                computers = currReq;
            }
            if (start.get(stIndex) < end.get(endIndex)) {
                stIndex++;
            } else {
                endIndex++;
            }
            while(stIndex<start.size() && endIndex<end.size() && start.get(stIndex)>= end.get(endIndex)){
                endIndex++;
            }
        }
        System.out.print(computers);

    }

    private static int toMins(String time) {
        String[] hourMins = time.split(":");
        int hours = Integer.parseInt(hourMins[0]);
        int mins = Integer.parseInt(hourMins[1]);
        return hours * 60 + mins;
    }
}
