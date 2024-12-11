import java.util.Scanner;
public class EqualCountOfVowelsAndConsonants {
    private static boolean isVowel(char ch){
        char ch1 = Character.toLowerCase(ch);
        return ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u';
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int len = s.length();
        int count = 0;
        int balance = 0;

        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i))){
                balance++;
            }
            else{
                balance--;
            }

        }
        if(balance == 0){
            count++;
        }

        for(int i=1;i<=len-n;i++){
            balance = balance + (isVowel(s.charAt(i-1)) ?-1:1);
            balance = balance + (isVowel(s.charAt(i+n-1))?1:-1);
            if(balance == 0){
                count++;
            }
        }
        System.out.print(count);



    }
}
