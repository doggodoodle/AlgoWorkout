package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created  on 1/15/19.
 */
public class CoupleSeating {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> seated = new HashMap<>();
        for (int i : row) {
            seated.put(row[i], i);
        }
        int swaps = 0;
        for (int i = 0; i<row.length-1; i=i+2) {
            int j = i+1;
            int a = row[i], b = row[j];
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if ((min%2 == 0) && (max == min+1)) {
                continue;
            }
            if (a%2 == 0) {
                int tmp = seated.get(a+1);
                row[j] = row[seated.get(a+1)];
                row[seated.get(a+1)] = b;
                seated.put(row[j], j);
                seated.put(b, tmp);
            }
            else {
                int tmp = seated.get(a-1);
                row[j] = row[seated.get(a-1)];
                row[seated.get(a-1)] = b;
                seated.put(row[j], j);
                seated.put(b, tmp);
            }

        }
        return swaps;
    }
}
