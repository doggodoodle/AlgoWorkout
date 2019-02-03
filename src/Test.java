import java.util.*;

/**
 * Created  on 1/6/17.
 */
public class Test {

    static HashMap<String, Boolean> map = new HashMap<String, Boolean>();


    public static void main(String[] args) {
        Double a = new Double(1);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        Test test = new Test();
        test.func1(a, set);
        System.out.println("a:"+a);
        System.out.println("set"+set);
    }

    private void func1(Double a, Set<Integer> set) {
        a = 2D;
        //set = new HashSet<>();
        set.add(2);
        //set.remove(1);
        //set.add(2);
    }


}
