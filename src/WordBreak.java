import java.util.*;
public class WordBreak {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split("\\s+");
        String str = in.nextLine();
        List<String> wordList = Arrays.asList(words);
        breakword(wordList, str, "", 0);

    }

    private static void breakword(List<String> wordList, String str, String output, int start) {
        if (start == str.length()) {
            System.out.println(output.trim());
            return;
        }

        for (int index = start; index < str.length(); index++) {
            String word = str.substring(start, index + 1);
            if (wordList.contains(word)) {
                breakword(wordList, str, output + word + " ", index + 1);
            }
        }
    }
}
