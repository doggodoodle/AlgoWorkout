package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstring {
    public static int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=extractPalindrome(s,i,i);//odd length
            count+=extractPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    public static int extractPalindrome(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aabaa"));
    }
}
