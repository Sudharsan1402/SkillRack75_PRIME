import java.util.*;
public class CombinationSubStringsSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> lst = new ArrayList<>();

        for (int ctr = 1; ctr < (1 << s.length()); ctr++) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < s.length(); index++) {
                if ((ctr & (1 << index)) != 0) {
                    sb.append(s.charAt(index));
                }
            }
            lst.add(sb.toString());
        }

        Collections.sort(lst);

        for (String str : lst) {
            System.out.println(str);
        }

    }
}
