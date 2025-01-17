import java.util.*;
class Link {
    int source, dest, dist;
}
public class SingleSourceShortestPath {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();

        List<Link> links = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            Link link = new Link();
            link.source = in.nextInt();
            link.dest = in.nextInt();
            link.dist = in.nextInt();
            links.add(link);
        }

        Integer[] shortest = new Integer[N + 1];
        shortest[1] = 0;
        boolean relaxed = true;

        for (int iter = 1; iter < N && relaxed; iter++) {
            relaxed = false;

            for (Link link : links) {
                if (shortest[link.source] == null) {
                    continue;
                }
                if (shortest[link.dest] == null || shortest[link.source] + link.dist < shortest[link.dest]) {
                    shortest[link.dest] = shortest[link.source] + link.dist;
                    relaxed = true;
                }
            }
        }

        for (int city = 2; city <= N; city++) {
            System.out.print(shortest[city] + " ");
        }
    }
}
