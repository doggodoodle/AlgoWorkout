import java.util.*;

/**
 * Created by ritvikmathur on 1/6/17.
 */
public class Test {

    static HashMap<String, Boolean> map = new HashMap<String, Boolean>();


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        Map<Integer, Integer> map2 = new HashMap<>();
        System.out.println(map.equals(map2));


    }

    static boolean isValid(String s){



        if(map.get(s)!=null)
            return map.get(s);


        if(s==null || s.isEmpty()){
            map.put(s, false);
            return false;
        }


        char ch = s.charAt(0);

        int i = 0;

        int ct = 0;
        for(char c : s.toCharArray()){

            if(c == ch)
                ct++;
            else
                break;

            i++;

        }

        int ct2=0;

        for(int j = i; j<s.length(); j++){
            if(s.charAt(j)==ch){
                map.put(s, false);
                return false;
            }


            ct2++;
        }

        if(ct!=ct2){
            map.put(s, false);
            return false;
        }

        map.put(s,true);


        return true;
    }

}
