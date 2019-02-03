package leetcode;

/**
 * Created  on 1/12/19.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        String A2 = A;
        int r = 1;
        if(A.contains(B))
            return r;
        // Set<Character> aSet = A.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
        // Set<Character> bSet = B.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
        // if (!aSet.containsAll(bSet)) {
        //     return -1;
        // }
        if (A.length() < B.length()) {
            while (A.length() < B.length()+(A2.length() * 1)) {
                A = A + A2;
                r++;
                if(A.contains(B))
                    return r;
            }
        } else {
            A = A + A2;
            r++;
            if(A.contains(B))
                return r;
            A = A + A2;
            r++;
            if(A.contains(B))
                return r;
            return -1;
        }

        return -1;
        //System.out.println(A+" - "+B+ " - "+ r);
        //System.out.println("R3");

    }

    public static void main(String[] args) {
        String A = "anc";
        A = A + A + A;

        System.out.println(A);
    }
}
