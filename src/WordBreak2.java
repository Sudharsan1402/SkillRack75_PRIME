import java.util.*;
public class WordBreak2 {

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String str=s.nextLine();
        int n=str.length();

        int m=s.nextInt();
        s.nextLine();
        String[]words=new String[m];
        for(int i=0;i<m;i++){
            words[i]=s.nextLine();
        }
        boolean dp[]=new boolean[n+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(String word:words){
                int start=i-word.length();
                if(start>=0 && dp[start] && str.substring(start,start+word.length()).equals(word)){
                    dp[i]=true;
                    break;
                }
            }
        }
        System.out.println((dp[n]==true?"Yes":"No"));
    }
}
