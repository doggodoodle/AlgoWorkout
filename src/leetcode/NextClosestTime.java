package leetcode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created  on 1/13/19.
 */
public class NextClosestTime {
    public static void main(String[] args) {
        DateFormat formatter = new SimpleDateFormat("HH:MM");

        Date date = null;
        try {
            date = formatter.parse("01:11");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, 1);

            System.out.println(calendar.get(Calendar.HOUR));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);

        Set<String> timeSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        String candidate = ""+digits[i]+""+digits[j]+":"+digits[k]+""+digits[l];
                        if (isValidTime(candidate)) timeSet.add(candidate);
                    }
                }
            }
        }

        List<String> timeList = new ArrayList<>();
        timeList.addAll(timeSet);
        Collections.sort(timeList);
        int index = timeList.indexOf(time);
        return index==timeList.size()-1 ? timeList.get(0) : timeList.get(index+1);

    }

    public boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}
