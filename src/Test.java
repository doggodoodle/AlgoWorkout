import java.util.*;

/**
 * Created by ritvikmathur on 12/24/16.
 */
public class Test {
    public static void main(String[] args) {
        Test app = new Test(2);
        //2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)]

        System.out.println(app.get(2));
        app.set(2,6);
        System.out.println("******");
        System.out.println("countMap="+app.countMap);
        System.out.println("dataMap="+app.dataMap);
        System.out.println("q="+app.q);
        System.out.println(app.get(1));
        app.set(1,5);
        System.out.println("******");
        System.out.println("countMap="+app.countMap);
        System.out.println("dataMap="+app.dataMap);
        System.out.println("q="+app.q);
        app.set(1,2);
        System.out.println("******");
        System.out.println("countMap="+app.countMap);
        System.out.println("dataMap="+app.dataMap);
        System.out.println("q="+app.q);


        System.out.println(app.get(1));

        System.out.println(app.get(2));




    }

    int capacity;

    HashMap<Integer, Integer> dataMap = new HashMap<Integer, Integer>();

    HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

    Queue<Integer> q = new ArrayDeque<Integer>(capacity);

    void removeOldest(){
        if(q.isEmpty())
            return;
        Integer k = q.remove();

        Integer count = countMap.get(k);

        if(count  == null || --count <= 0){
            countMap.remove(k);
            dataMap.remove(k);
        }
        else{
            countMap.put(k, count);
        }
    }

    public Test(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        Integer count = countMap.get(key);

        if(count == null)
            return -1;
        else{

            int data = dataMap.get(key);

            if(q.size() >= capacity){
                removeOldest();
            }

            q.add(key);
            dataMap.put(key, data);

            Integer count2 = countMap.get(key);

            if(count2 == null)
                countMap.put(key, 1);
            else{
                count2++;
                countMap.put(key, count2);
            }

            return dataMap.get(key);
        }
    }

    public void set(int key, int value) {


        if(q.size() >= capacity){
            removeOldest();
        }
        q.add(key);
        dataMap.put(key, value);
        Integer count = countMap.get(key);
        if(count == null)
            countMap.put(key, 1);
        else{
            count++;
            countMap.put(key, count);
        }

    }
}

/*
1 2
-->

 */
