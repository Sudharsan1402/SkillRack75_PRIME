import java.util.*;
public class TallestBillboard {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
            sum+=arr[i];
        }
        int dp[]=new int[sum+1];
        dp[0]=0;
        for(int i=1;i<=sum;i++){
            dp[i]=-1;
        }
        for(int rod:arr){
            int newdp[]=new int[sum+1];
            newdp=Arrays.copyOf(dp,sum+1);
            for(int i=0;i<=sum-rod;i++){
                if(newdp[i]<0){
                    continue;
                }
                dp[i+rod]=Math.max(dp[i+rod],newdp[i]);
                dp[Math.abs(i-rod)]=Math.max(dp[Math.abs(i-rod)],Math.min(i,rod)+newdp[i]);
            }

        }
        System.out.println(dp[0]);
    }
}
