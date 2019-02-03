package leetcode.design;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created  on 1/16/19.
 *
 * https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/264/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays {
    int n = 0;
    public int numDecodings(String s) {
        if (s.equals("")) {
            return 0;
        }
        int[] arr = s.chars().map(n -> n - '0').toArray();
        traverse(arr, 0);
        return n;
    }

    void traverse(int[] arr, int i) {
        if(i<arr.length && arr[i] == 0) {
            return;
        }
        if(i >= arr.length-1) {
            n++;
            return;
        }
        traverse(arr, i+1);
        int doub = (arr[i] * 10) + arr[i+1];
        if (doub <= 26) {
            traverse(arr, i+2);
        }
    }

    public static void main(String[] args) {
        String a = "123123123123123";
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings(a));
    }
}
