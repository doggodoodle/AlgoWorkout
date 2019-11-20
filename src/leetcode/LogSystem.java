package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LogSystem {

    Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>>>>> map = new HashMap<>();

    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        String [] split = timestamp.split(":");
        Integer yyyy = Integer.parseInt(split[0]);
        Integer mm = Integer.parseInt(split[1]);
        Integer dd = Integer.parseInt(split[2]);
        Integer hh = Integer.parseInt(split[3]);
        Integer MM = Integer.parseInt(split[4]);
        Integer ss = Integer.parseInt(split[5]);

        map.computeIfAbsent(yyyy, a -> new HashMap<>())
                .computeIfAbsent(mm, b -> new HashMap<>())
                .computeIfAbsent(dd, c -> new HashMap<>())
                .computeIfAbsent(hh, d -> new HashMap<>())
                .computeIfAbsent(MM, e -> new HashMap<>())
                .computeIfAbsent(ss, f -> new HashSet<>()).add(id);

        System.out.println(map);
    }

    public List<Integer> retrieve(String st, String en, String gra) {
        List<Integer> res = new ArrayList<>();

        String [] s = st.split(":");
        Integer yyyy1 = Integer.parseInt(s[0]);
        Integer mm1 = Integer.parseInt(s[1]);
        Integer dd1 = Integer.parseInt(s[2]);
        Integer hh1 = Integer.parseInt(s[3]);
        Integer MM1 = Integer.parseInt(s[4]);
        Integer ss1 = Integer.parseInt(s[5]);

        String [] e = en.split(":");
        Integer yyyy2 = Integer.parseInt(e[0]);
        Integer mm2 = Integer.parseInt(e[1]);
        Integer dd2 = Integer.parseInt(e[2]);
        Integer hh2 = Integer.parseInt(e[3]);
        Integer MM2 = Integer.parseInt(e[4]);
        Integer ss2 = Integer.parseInt(e[5]);


        for (int i = yyyy1; i <= yyyy2; i++) {
            if (map.get(i) != null) {
                Map<Integer, Map<Integer, Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>>>> months = map.get(i);
                for (int j = (!gra.equals("Year") ? mm1 : 1); j <= (!gra.equals("Year") ? mm2 : 12); j++) {
                    if (months.get(j) != null) {
                        Map<Integer, Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>>> days = months.get(j);
                        for (int k = (!gra.equals("Year") && !gra.equals("Month") ? dd1 : 1); k <= (!gra.equals("Year") && !gra.equals("Month") ? dd2 : 31); k++) {
                            if (days.get(k) != null) {
                                Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>> hours = days.get(k);
                                for (int l = (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") ? hh1 : 1); l <= (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") ? hh2 : 24); l++) {
                                    if (hours.get(l) != null) {
                                        Map<Integer, Map<Integer, Set<Integer>>> minutes = hours.get(l);
                                        for (int m = (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") && !gra.equals("Hour") ? MM1 : 1); m <= (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") && !gra.equals("Hour") ? MM2 : 60); m++) {
                                            if (minutes.get(m) != null) {
                                                Map<Integer, Set<Integer>> seconds = minutes.get(m);
                                                for (int n = (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") && !gra.equals("Hour") && !gra.equals("Minute") ? ss1 : 1); n <= (!gra.equals("Year") && !gra.equals("Month") && !gra.equals("Day") && !gra.equals("Hour") && !gra.equals("Minute")  ? ss2 : 60); n++) {
                                                    if (seconds.get(n) != null) {
                                                        res.addAll(seconds.get(n));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }



        return res;



    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
