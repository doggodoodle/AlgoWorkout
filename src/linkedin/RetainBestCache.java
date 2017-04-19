package linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ritvikmathur on 2/25/17.
 *
 * LI phone iv question on 02/24/2017
 *
 * #TODO:
 * - MinHeap to store nodes by rank
 * - Add code to store nodes to minheap using getRank
 *
 *
 *
 */
public class RetainBestCache<K, T extends Rankable> {

    int entriesToRetain;

    DataSource<K,T> ds;

    Map<K,T> map;



    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K,T> ds, int entriesToRetain) {
        // Implementation here
        this.entriesToRetain = entriesToRetain;
        this.ds = ds;
        map = new HashMap<K,T>(entriesToRetain);

    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempts to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        // Implementation here
        T entry = map.get(key);
        if(entry==null){
            entry = ds.get(key);
            if(map.size()>=entriesToRetain){
                K lowest=null;//get lowest from heap
                map.remove(lowest);
            }
            map.put(key,entry);
            //insert rank to heap
        }

        return entry;

    }
}

/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */

interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();
}

interface DataSource<K, T extends Rankable> {
    T get (K key);
}
