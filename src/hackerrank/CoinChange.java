package hackerrank;

/**
 * Created  on 12/30/16.
 */
public class CoinChange {

    public static void main(String[] args) {
        //combs(4,"");
        System.out.println("Tiger".compareTo("Tiger"));
        ;
    }

    static String combs(int n, String s){
        if(n==0) {
            System.out.println(s);
            return 0 + s;
        }



        StringBuilder sb = new StringBuilder(s);
        sb.append(","+n+"+"+0+",");
        sb.append("1+");

        return combs(n-1,sb.toString());
    }
}
