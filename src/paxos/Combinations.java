package paxos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ritvikmathur on 12/7/16.
 */
public class Combinations {

    public static void main(String[] args) {
        //String st = ("X0IOIJOFJOIDSFJXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        String st = args[0];
        int countX = countX(st);
        if(countX==0){
            System.out.println(st);
            System.exit(0);
        }

        System.out.println("count="+countX);

        combinations(countX, st);
    }

    static void combinations(double size, String st){
        System.out.println("evaluating combinations..");
        double count = Math.pow(2,size);
        for(int i=0;i<count; i++){
            String s = Integer.toBinaryString(i);
            double diff = size-s.length();
            if(diff>0){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < diff; j++){
                    sb.append("0");
                }
                s = sb.toString()+""+s;
            }
            int p = 0;
            StringBuilder res = new StringBuilder(st);
            for(int j = 0; j<res.length(); j++){
                if(res.charAt(j) == 'X'){
                    res.replace(j,j+1, String.valueOf(s.charAt(p)));
                    p++;
                }
            }
            System.out.println(res.toString());
        }

    }

    private static int countX(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='X')
                count++;
        }
        return count;
    }
}
