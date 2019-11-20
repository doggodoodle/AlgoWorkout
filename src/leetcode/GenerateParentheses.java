package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add("(");
            list.add(")");
        }
        System.out.println(list);
        List<String> res = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            visit(i, new HashSet<>(), list, new StringBuilder(), res, 0, 0, n);
//        }
        visit(0, new HashSet<>(), list, new StringBuilder(), res, 0, 0, n);
        return new ArrayList<>(res);
    }

    static void visit(int idx, Set<Integer> visited, List<String> list, StringBuilder sb, List<String> res, int op, int cl, int n) {
        System.out.println("visited:" + visited);
        if (visited.contains(idx)) {
            return;
        }
        visited.add(idx);
        if (list.get(idx).equals(")")) {
            if (cl + 1 > op) {
                return;
            } else {
                cl++;
                sb.append(list.get(idx));
            }
        } else if (list.get(idx).equals("(")) {
            if (op >= n) {
                return;
            } else {
                op++;
                sb.append(list.get(idx));
            }
        }
        if (sb.length() >= list.size()) {
            res.add(sb.toString());
            return;
        }

        System.out.println("sb:" + sb);
        for (int i = 0; i < list.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }
            visit(i, new HashSet<>(visited), list, new StringBuilder(sb), res, op, cl, n);
        }
    }
}
