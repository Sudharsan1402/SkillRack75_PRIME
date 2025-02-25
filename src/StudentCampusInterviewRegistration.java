import java.util.*;
public class StudentCampusInterviewRegistration {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int start=s.nextInt();
        int end=s.nextInt();
        List<int[]> intervals=new ArrayList<>();
        for(int i=0;i<n;i++){
            int st=s.nextInt();
            int en=s.nextInt();
            if(st<end && en>start){
                intervals.add(new int[]{Math.max(start,st),Math.min(end,en)});
            }

        }
        intervals.sort((a,b)->Integer.compare(a[1],b[1]));
        int last_end_time=start,count=0;
        for(int[]interval:intervals){
            if(interval[0]>=last_end_time){
                count++;
                last_end_time=interval[1];
            }
        }
        System.out.println(count);
    }
}
