import java.util.*;
public class Longestvalidparenthesesubstring {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        int maxlen=0;
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.empty()){
                    st.push(i);
                }
                else{
                    maxlen=Math.max(maxlen,i-st.peek());
                }
            }
        }
        System.out.println(maxlen);
    }
}
