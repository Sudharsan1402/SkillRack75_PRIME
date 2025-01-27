import java.util.*;
public class MinimumCosttoVisitNcities {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int R = in.nextInt();
        int matrix[][] = new int[N+1][N+1];
        boolean visited[] = new boolean[N+1];
        for(int city=1; city<=N; city++) {
            visited[city] = false;
            for(int othCity=1; othCity<=N; othCity++) {
                matrix[city][othCity] = -1;
            }
        }

        int minCostSrc=0, minCostDest=0, minCost=Integer.MAX_VALUE;
        for(int road=1; road<=R; road++) {
            int src = in.nextInt();
            int dest = in.nextInt();
            int cost = in.nextInt();
            matrix[src][dest] = matrix[dest][src] = cost;
            if(cost < minCost) {
                minCost = cost;
                minCostSrc = src;
                minCostDest = dest;
            }
        }

        int totalMinCost=minCost, remainingCities=N-2;
        visited[minCostSrc] = visited[minCostDest] = true;
        while(remainingCities > 0) {
            minCost = Integer.MAX_VALUE;
            for(int city=1; city<=N; city++) {
                if(visited[city] == true) {
                    for(int oth=1; oth<=N; oth++) {
                        if(city==oth || visited[oth] || matrix[city][oth]==-1) {
                            continue;
                        }
                        if(matrix[city][oth] < minCost) {
                            minCost = matrix[city][oth];
                            minCostDest = oth;
                        }
                    }
                }
            }
            totalMinCost += minCost;
            visited[minCostDest] = true;
            remainingCities--;
        }
        System.out.print(totalMinCost);

    }
}
