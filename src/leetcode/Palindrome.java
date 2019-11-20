package leetcode;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            String t = c + "";
            //System.out.println(t);
            if (!t.trim().isEmpty() && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                sb.append(t.toUpperCase());
            } else {
                System.out.println("Skipping:" + c);
            }
        }
        String in = sb.toString();
        System.out.println(in);
        if (in.length() <= 1) {
            return true;
        }
        //0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i <= in.length()/2 - 1; i++) {
            System.out.println("Checking:" + in.charAt(i) + " and " + in.charAt(in.length() - 1 - i));
            if (!(in.charAt(i) + "").equals((in.charAt(in.length() - 1 - i) + ""))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
