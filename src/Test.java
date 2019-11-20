import java.util.*;

/**
 * Created  on 1/6/17.
 */
public class Test {

    static HashMap<String, Boolean> map = new HashMap<String, Boolean>();


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(4);
        l.add(16);
        Iterator<Integer> iterator = l.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    private void func1(Double a, Set<Integer> set) {
        a = 2D;
        //set = new HashSet<>();
        set.add(2);
        //set.remove(1);
        //set.add(2);
    }


}
