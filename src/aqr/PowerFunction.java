package aqr;

/**
 */
public class PowerFunction {

    static int power(int p, int q){
        System.out.println("power:"+p+ "^"+q);
        if(q == 0)
            return 1;
        if(q == 1)
            return p;
        if(q%2 == 0)
            return power(p * p, q/2);
        else
            return p * power(p*p, q/2);
    }

    static int dumbPower(int p, int q){
        System.out.println("dumbPower:"+p+ "^"+q);
        if(q == 0)
            return 1;
        if(q == 1)
            return p;

        return p * dumbPower(p, q-1);
    }

    public static void main(String[] args) {
        System.out.println(dumbPower(5,4));
    }
}
