package puzzles;

/**
 * Created  on 5/1/17.
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        partition.partition(5);
    }

    void partition(int n){
        int [] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i+1;
        }
        partition(0,list, 0,"",n);
    }

    void partition(int i, int[] list, int sum, String s, int n){
        sum = sum + list[i];

        if(s.isEmpty())
            s = ""+list[i];
        else
            s = s+ " + "+list[i];

        if(sum == n){
            System.out.println(s);
            return;
        }
        else if(sum > n)
            return;
        else {
            for (int j = 0; j < list.length; j++) {
                partition(j, list, sum, s, n);
            }
        }
    }
}
