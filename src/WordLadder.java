import java.util.*;
class WordandLen {
    String word;
    int len;

    WordandLen(String word, int len) {
        this.word = word;
        this.len = len;
    }
}
public class WordLadder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] inp = s.nextLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        String startword = inp[1];
        String endword = inp[2];
        Set<String> wordList = new HashSet<>();
        String[] input = s.nextLine().split(" ");
        for (String a : input) {
            wordList.add(a);
        }

        WordandLen w = new WordandLen(startword, 1);
        Queue<WordandLen> q = new LinkedList<>();
        q.add(w);

        while (!q.isEmpty()) {
            WordandLen currword = q.poll();
            String word = currword.word;
            int len = currword.len;
            char[] wordarray = word.toCharArray();

            if (word.equals(endword)) {
                System.out.println(len);
                return;
            }

            for (int i = 0; i < word.length(); i++) {
                char currentchar = wordarray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordarray[i] = c;
                    String neword = new String(wordarray);
                    if (wordList.contains(neword)) {
                        q.add(new WordandLen(neword, len + 1));
                        wordList.remove(neword);
                    }
                }
                wordarray[i] = currentchar;
            }
        }
        System.out.println(0);
    }


}
