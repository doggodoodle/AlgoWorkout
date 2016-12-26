package paxos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ritvikmathur on 12/7/16.\
 *
 * Given a list of sorted values (let’s call them utxos), find exactly two distinct members of that list

 that are at or minimally over a certain amount (say, target). If no pair of utxos are at or over the

 target, we print “Not possible”

 The program takes two inputs, the first is a filename with a list of values and the second input is

 the target value.

 The file looks like this:

 $ cat input_file.txt

 abcdef 17

 e478ab 20

 a84739 23

 …

 e4738a 137

 fff483 141

 The first column is a unique identifier of the utxo and the second is the value of that utxo,which

 is always a positive integer.

 $ find-pair &lt;filename&gt; &lt;some value&gt;
 */
public class FindPair {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if(file==null){
            System.out.println("File not found!");
            System.exit(0);
        }
        int sum = Integer.parseInt(args[1]);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> strings = new ArrayList<String>();
        List<Integer> ints = new ArrayList<Integer>();
        while (sc.hasNext()){
            strings.add(sc.next());
            ints.add(sc.nextInt());
        }
        int[] indices = find(ints, sum);
        if(indices.length==0)
            System.out.println("Not possible");
        else if(indices.length==2)
            System.out.println(strings.get(indices[0])+" "+ints.get(indices[0])+", "+strings.get(indices[1])+" "+ints.get(indices[1]));
        else
            System.out.println("Error!");
    }

    static int[] find(List<Integer> ints, int sum){
        Integer temp1=null, temp2=null;


        for(int i=0; i<ints.size(); i++){

            int k = sum - ints.get(i);

            for(int j = 0; j<ints.size(); j++){
                if(j==i)
                    continue;
                if(ints.get(j)==k){
                    return new int[]{i, j};
                }
                if(ints.get(j)>k){
                    if(temp1==null){
                        temp1=i;
                        temp2=j;
                    }
                    else if(ints.get(temp1)+ints.get(temp2) > ints.get(i)+ints.get(j)){
                        temp1=i;
                        temp2=j;
                    }
                }
            }
        }

        if(temp1!=null)
            return new int[]{temp1, temp2};

        return new int[0];
    }
}
