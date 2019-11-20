package amz;

import java.util.*;

public class BestDeliveryPath {

    static int minDist = Integer.MAX_VALUE;

    static List<List<Integer>> bestPath = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> destinations = Arrays.asList(
                Arrays.asList(9,10),
                Arrays.asList(1,2),
                Arrays.asList(1,1),
                Arrays.asList(3,4),
                Arrays.asList(1,-1),
                Arrays.asList(19,10)
        );
        //Should return List <(1,2), 19,10)>
        System.out.println(bestPath(destinations, 4));
    }

    static List<List<Integer>> bestPath(List<List<Integer>> destinations, int allowedDestinations) {
        for (int i = 0; i < destinations.size(); i++) {
            getDistance(destinations, allowedDestinations, Arrays.asList(0,0),
                    destinations.get(i), 0, new HashSet<>(Arrays.asList(i)), new ArrayList<>());
        }
        return bestPath;
    }

    static void getDistance(List<List<Integer>> destinations, int allowedDestinations, List<Integer> prev,
                           List<Integer> next, int dist, Set<Integer> visited, List<List<Integer>> path2) {
        int d = getDist(prev, next);
        dist += d;
        List<List<Integer>> path = new ArrayList<>(path2);
        if (allowedDestinations <= visited.size()) {
            if(minDist >= dist) {
                path.add(next);
                minDist = dist;
                bestPath = path;
            }
            return;
        }
        path.add(next);
        for (int i = 0; i < destinations.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }
            Set<Integer> visited2 = new HashSet<>(visited);
            visited2.add(i);
            getDistance(destinations, allowedDestinations, next,
                    destinations.get(i), dist, visited2, path);
        }
    }

    private static int getDist(List<Integer> prev, List<Integer> next) {
        return ((next.get(0) - prev.get(0)) * (next.get(0) - prev.get(0)))
                + ((next.get(1) - prev.get(1)) * (next.get(1) - prev.get(1)));
    }
}
