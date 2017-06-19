package zocdoc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ritvikmathur on 5/12/17.
 */
public class KelvinBacon {
    /*
    *
    *
    *
    * */

    static Map<String, Set<String>> aToM; //actor to movies
    static Map<String, Set<String>> mToA; //movie to actors

    /**
     ryan - notebook, lalaland
     emma - lalaland
     rachel - notebook
     d(ryan, emma) =1
     d(rachel, emma) =2

     */

    int getDistance(String actor1, String actor2){
        //rachel emma
        getDistance(actor1, actor2, 0, new HashSet<String>(), new HashSet<String>());

        return minDist;

    }


    static int minDist = Integer.MAX_VALUE;

    static void getDistance(String actor1, String actor2, int dist, Set<String> visitedA, Set<String> visitedM){

        if(visitedA.contains(actor1))
            return;

        visitedA.add(actor1);

        dist ++; //1

        for(String movie : aToM.get(actor1)){
            if(visitedM.contains(movie))
                continue;
            if(mToA.get(movie).contains(actor2)){
                minDist = Math.min(minDist, dist);
                return;
            }
            else{
                for(String actor : mToA.get(movie)){ // { rachel, ryan }
                    visitedM.add(movie);
                    getDistance(actor, actor2, dist, new HashSet<>(visitedA), new HashSet<>(visitedM));
                }
            }

        }

    }







}
