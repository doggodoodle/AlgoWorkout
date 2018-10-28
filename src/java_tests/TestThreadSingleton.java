package java_tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by ritvikmathur on 6/20/17.
 */
public class TestThreadSingleton {
    public static void main(String[] args) {
        TestThreadSingleton testThreadSingleton = new TestThreadSingleton();
        testThreadSingleton.runTest();
    }

    public void runTest() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.submit(new Tsk(map, i));
        }
        System.out.println(map);
        executorService.shutdown();
    }

    public class Tsk implements Runnable {
        int id;
        Map<String, Integer> map;
        public Tsk(Map<String, Integer> map, int id) {
            this.map = map;
            this.id = id;
        }
        @Override
        public void run() {
            map.putIfAbsent(id+"", 1);
            while(!map.values().stream().anyMatch(v -> v>=20)) {
                EnumSingleton.INSTANCE.processSecurity(map, map.get(id+""), id);
                System.out.println("Thread #"+ id + map);
            }
        }
    }
}
