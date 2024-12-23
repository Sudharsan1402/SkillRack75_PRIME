
import java.util.*;
public class LongestSubstringofequalnoofalphabetsandnumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int counter = 0, position = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(counter, position);

        for (char ch : s.toCharArray()) {
            position++;

            if (Character.isAlphabetic(ch)) {
                counter++;
            } else {
                counter--;
            }

            if (map.containsKey(counter)) {
                int currLen = position - map.get(counter);
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(counter, position);
            }
        }

        System.out.print(maxLen);

    }
}
