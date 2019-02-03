package leetcode;

/**
 * Created  on 2/18/17.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {3,100,12,2,3,5};
        System.out.println(rob(arr));
        /*n:3 prevNo:0 prevYes:0
        n:100 prevNo:0 prevYes:3
        n:12 prevNo:3 prevYes:100
        n:2 prevNo:100 prevYes:15
        n:3 prevNo:100 prevYes:102
        n:5 prevNo:102 prevYes:103
        107*/


    }

    static int rob(int[] num) {

       int prevYes = 0, prevNo = 0;
        for(int n : num){
            System.out.println("n:"+n+" prevNo:"+prevNo+" prevYes:"+prevYes);
            int temp = prevNo;
            prevNo = prevYes;
            prevYes = Math.max(prevNo,n+temp);


        }
        return Math.max(prevNo,prevYes);
    }
}
