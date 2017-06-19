package twosigma;

import java.util.*;

/**
 * Created by ritvikmathur on 6/1/17.
 *
 * Question 2:

 Oh no! Disaster has struck some of ACME&#39;s redundant data centers. The administrators have managed

 to restore backups, but some data sets are still missing from some data centers. Fortunately, every data

 set can be found at least once in one or more of the data centers. However, before ACME can resume

 normal operations, it needs to ensure that each data center has a copy of every data set. Your goal is to

 help ACME resume normal operations as quickly as possible by writing a program to synchronize data

 sets between data centers using as few copies as possible.

 Input:

 The first line of input will contain an integer between 0 and 999999 inclusive, representing the number

 of data centers. Following that will be one line of input for each data center with a space-separated list

 of data set ids currently present at that data center. Data set ids are each an integer between 1 and

 999999, inclusive. Each line will be at most 1000 characters long. A data center with no data sets is

 represented with a blank line. Data set ids are not necessarily consecutive. The list of data sets will not

 be in any particular order.

 Output:

 The program must output an optimal data set copy strategy to ensure that every data center has a copy

 of every data set. Output one line for every copy instruction.

 A copy instruction is of the form &lt;data-set- id&gt; &lt;from&gt; &lt;to&gt;, where &lt;data-set- id&gt; is the data set id,

 &lt;from&gt; is the index of the data center the data set will be copied from (1 = the first data center), and

 &lt;to&gt; is the index of the data center to copy the data set to. When there are no more copy instructions,

 the program must output the word &quot;done&quot; on a line by itself. There is often more than one correct

 output for a given input, and any output that satisfies the requirements is valid.

 Constraints:

 The code you submit must take input from stdin and produce output to stdout as specified above. No

 other output is permitted. You can assume the input will be valid.
 */
public class RedundantDataCenters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Set<Integer>> list = new ArrayList<>(n);
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> dSet = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            String line = sc.nextLine();
            String[] ints = line.split(" ");
            Set<Integer> l = new HashSet<>();
            for(String s : ints) {

                int c = Integer.parseInt(s);
                dSet.add(c);

                l.add(c);
                if(map.get(c)==null){

                    map.put(c,i+1);
                }
            }
            list.add(l);
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).size()==dSet.size())
                continue;
            for(Integer d : dSet){
                if(!list.get(i).contains(d))
                    System.out.println(d+ " "+map.get(d)+" "+(i+1));
            }


        }
        System.out.println("done");
        System.out.println(map);

    }
}



