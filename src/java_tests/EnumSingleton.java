package java_tests;

import java.util.Map;

/**
 * Created  on 6/20/17.
 */
public enum EnumSingleton {

    INSTANCE;

    private int var = 99;

    public int i = 0;

    public static String doWhatever(String s) {
        return s.replaceFirst("a", "b");
    }

    public void processSecurity(Map<String, Integer> map, Integer sec, int tid) {
        map.put(tid+"", map.get(tid+"")+1);
    }
}
