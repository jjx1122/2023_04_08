
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class test8 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个字符串:");
            String s = scanner.nextLine();
            String[] ans = longestSubstringWithoutRepeatingChars(s);
            System.out.println("所有最长无重复子串：");
            for (String str : ans) {
                System.out.println(str);
            }
        }

        public static String[] longestSubstringWithoutRepeatingChars(String s) {
            int n = s.length();
            int maxLength = 0;
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Set<Character> set = new HashSet<>();
                StringBuilder cur = new StringBuilder();
                for (int j = i; j < n; j++) {
                    char c = s.charAt(j);
                    if (!set.contains(c)) {
                        set.add(c);
                        cur.append(c);
                    } else {
                        break;
                    }
                }
                if (cur.length() > maxLength) {
                    maxLength = cur.length();
                    temp.clear();
                    temp.add(cur.toString());
                } else if (cur.length() == maxLength) {
                    temp.add(cur.toString());
                }
            }
            String[] ans = new String[temp.size()];
            ans = temp.toArray(ans);
            return ans;
        }
}

