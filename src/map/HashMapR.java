package map;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ritvikmathur on 4/9/17.
 */
public class HashMapR {
    String name;
    Integer age;
    Date dob;

    @Override
    public boolean equals(Object o) {
        Queue<Integer> q= new ArrayBlockingQueue<Integer>(1);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashMapR hashMapR = (HashMapR) o;

        if (name != null ? !name.equals(hashMapR.name) : hashMapR.name != null) return false;
        if (age != null ? !age.equals(hashMapR.age) : hashMapR.age != null) return false;
        return dob != null ? dob.equals(hashMapR.dob) : hashMapR.dob == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(2^8);
        System.out.println(getSupplementalHash(16));

        for (int i = 0; i < 20; i++) {
            System.out.println(i+": "+(i & (1024-1)));
        }
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(15));

        System.out.println((257 & (16-1)));
    }

    private static int getSupplementalHash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
