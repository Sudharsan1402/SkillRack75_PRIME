import java.util.*;
public class ValidMixOfStrings {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                String str1 = in.nextLine();
                String str2 = in.nextLine();
                String mix = in.nextLine();

                if (str1.length() + str2.length() != mix.length()) {
                    System.out.print("NO");
                    return;
                }

                if (isValid(str1, str2, mix, 0, 0, 0)) {
                    System.out.print("YES");
                } else {
                    System.out.print("NO");
                }
    }

            private static boolean isValid(String str1, String str2, String mix, int index1, int index2, int mixindex) {
                while (mixindex < mix.length()) {
                    if (index1 < str1.length() && index2 < str2.length() && str1.charAt(index1) == mix.charAt(mixindex) && str2.charAt(index2) == mix.charAt(mixindex)) {
                        if (isValid(str1, str2, mix, index1 + 1, index2, mixindex + 1)) {
                            return true;
                        } else {
                            return isValid(str1, str2, mix, index1, index2 + 1, mixindex + 1);
                        }
                    } else if (index1 < str1.length() && str1.charAt(index1) == mix.charAt(mixindex)) {
                        index1++;
                        mixindex++;
                    } else if (index2 < str2.length() && str2.charAt(index2) == mix.charAt(mixindex)) {
                        index2++;
                        mixindex++;
                    } else {
                        return false;
                    }
                }
                return true;
            }

}
