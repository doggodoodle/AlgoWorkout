package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-music-playlists/
 */

class MusicPlaylists {

    public static void main(String[] args) {
        MusicPlaylists musicPlaylists = new MusicPlaylists();
        System.out.println(musicPlaylists.numMusicPlaylists(3, 3, 1));
    }

    int res = 0;
    public int numMusicPlaylists(int N, int L, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        //System.out.println("list" + list);
        for (int i = 0; i < N; i++) {
            traverse(list, new LinkedList<>(), K, L, 0, i, new ArrayList<>());
        }
        return res;
    }


    void traverse(List<Integer> list, Queue<Integer> visited, int K, int L, int cnt, int idx, List<Integer> content) {
        //System.out.println("idx" + idx);
        //System.out.println("vis:" + visited);
        if (visited.contains(list.get(idx))) {
            return;
        }
        if (cnt >= L) {
            res++;
            System.out.println(content);
            return;
        }
        content.add(list.get(idx));
        cnt ++;

        visited.offer(list.get(idx));
        if (visited.size() > K) {
            visited.poll();
        }

        for (int i = 0; i < list.size(); i++) {
            traverse(list, new LinkedList<>(visited), K, L, cnt, i, new ArrayList<>(content));
        }
    }
}
