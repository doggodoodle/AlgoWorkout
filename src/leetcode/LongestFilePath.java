package leetcode;

/**
 * Created by ritvikmathur on 1/31/17.
 */
public class LongestFilePath {

    public static void main(String[] args) {
        lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }

    public static int lengthLongestPath(String input) {

        //"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"

        String [] splits = input.split("\n");

        String [] types = new String[splits.length];

        int [] tiers = new int[splits.length];

        int [] lengths = new int[splits.length];

        int i = 0;
        for(String s : splits){
            if(s.contains("."))
                types[i] = "f";
            else
                types[i] = "d";

            if(s.charAt(0) != '\t'){
                tiers[i] = 0;
                lengths[i] = s.length();
            }
            else{
                int tier = 0;
                int length = 0;
                //System.out.println("word:"+s);
                for(int j = 0; j < s.length(); j++){
                    if(s.charAt(j) == '\t'){
                        tier++;
                    }
                    else{
                        length++;
                    }
                }
                //System.out.println("tier:"+tier);
                tiers[i] = tier;
                int p = i -1;
                while (tier != tiers[p]+1) {
                    //System.out.println("p:"+p+" tier:"+tier);
                    p--;
                    //System.out.println("p:"+p);
                }
                lengths[i] = length+1+lengths[p];

            }

            i++;

        }

        int r = 0;

        for(int k = 0; k < splits.length; k++){

            /*System.out.print(" word:"+splits[k]);
            System.out.print(" tier:"+tiers[k] );
            System.out.print(" length:"+lengths[k]);
            System.out.print(" type:"+ types[k]);
            System.out.print(" - ");*/

            if(types[k].equals("f")){
                if(lengths[k] > r)
                    r = lengths[k];
            }

        }

        //System.out.println("r="+r);

        return r;





    }
}
