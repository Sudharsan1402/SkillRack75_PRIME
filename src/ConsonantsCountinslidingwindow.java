import java.util.Scanner;
public class ConsonantsCountinslidingwindow {

    private static boolean isVowel(char ch){
        char ch1 = Character.toLowerCase(ch);
        return ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u';
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        String S = in.next();
        int N = S.length();
        int count = 0;
        for(int i=0;i<K;i++){
            if(!isVowel(S.charAt(i))){
                count++;
            }

        }
        System.out.print(count + " ");

        for(int i=1;i<=N-K;i++){
            if(!isVowel(S.charAt(i-1))){
                count--;
            }
            if(!isVowel(S.charAt(i+K-1))){
                count++;
            }

            System.out.print(count + " ");
        }
    }
}
