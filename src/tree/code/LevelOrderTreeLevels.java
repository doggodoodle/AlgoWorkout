package tree.code;

import java.util.*;

/**
 * Created by ritvikmathur on 12/24/16.
 *
 * To get level order levels from array representation of tree
 */
public class LevelOrderTreeLevels {

    static int findMax(int n, String tree) {



        String [] strs = tree.split(" ");

        HashMap<Integer, List<String>> listMain = new LinkedHashMap<Integer, List<String>>();

        int size = 1;
        for(String s : strs){

            System.out.println("inserting "+s);

            List<String> set = listMain.get(size);

            if(set == null){
                listMain.put(size, new ArrayList<String>(Arrays.asList(s)));
                continue;
            }

            if(set.size() < size){
                set.add(s);
                listMain.put(size,set);
                continue;
            }

            if(set.size() == size){
                size = size*2;
                listMain.put(size, new ArrayList<String>(Arrays.asList(s)));
            }

        }

        System.out.println(listMain);

        int a = 0, b = 0;

        boolean bool = false;
        for(List<String> set : listMain.values()){
            int sum = 0;
            for(String s : set){
                if (s.equals("#"))
                    continue;
                sum = sum + Integer.parseInt(s);
            }
            if(!bool) {
                a = sum + a;
                bool = !bool;
            }
            else{
                b = sum + b;
                bool = !bool;
            }


        }


        return Math.max(a,b);


    }

}
