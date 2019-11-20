package leetcode;

public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        boolean skipped = false;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else if (!skipped) {
                if (s.charAt(i+1) == s.charAt(j)) {
                    i = i + 2;
                    j--;
                    skipped = true;
                    continue;
                } else if(s.charAt(i) == s.charAt(j-1)) {
                    i++;
                    j = j-2;
                    skipped = true;
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
