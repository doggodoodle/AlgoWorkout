//package lift;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
////public class Solution {
////    import java.io.*;
////import java.util.*;
//
//    /*
//     * To execute Java, please define "static void main" on a class
//å
//
//
///*
//
//Problem Description
//
//A third-party API that we're using has a paginated API. It returns results in chunks of 10. The API method is called fetchPage and returns:
//
//{
//  "results": [...],
//  "placeholder": "some opaque string"
//}
//
//placeholder can be used to make a re-request to get the next set of results. We don't think that API is very useful, and would like to implement a single function that fetches n number of results from fetchPage and abstracts away the pagination.
//
//Your task will be to implement this fetch functionality.
//
//// 3rd party API (provided)
//APIResult res_1_to_10 = ThirdPartyAPI.fetchPage(null);
//// res_1_to_10.results is a List<Integer> with the first 10 results
//APIResult res_11_to_20 = ThirdPartyAPI.fetchPage(res_1_to_10.placeholder);
//APIResult res_21_to_30 = ThirdPartyAPI.fetchPage(res_11_to_20.placeholder);
//
//// Wrapper (to implement)
//Fetcher fetcher = new Fetcher();
//List<Integer> res_1_to_5 = fetcher.fetch(5); // calls fetchPage 1 time
//List<Integer> res_6_to_21 = fetcher.fetch(16); // calls fetchPage 2 times
//List<Integer> res_22_to_30 = fetcher.fetch(9); // calls fetchPage 0 times
//*/
//
//    public class Fetcher {
//
//        Queue<Integer> queue;
//
//        String placeholder = null;
//
//        public Fetcher() {
//            queue = new LinkedList();
//        }
//
//        public List<Integer> fetch(int n) {
//            List<Integer> results = new ArrayList<>();
//            while (results.size() <= n) {
//                if (queue.size() <= 0) {
//                    fetchFromApi();
//                }
//                results.add(queue.poll());
//            }
//            return results;
//        }
//
//        private void fetchFromApi() {
//            APIResult apiResult = null;//ThirdPartyAPI.fetchPage(placeholder);
//            for (int i : apiResult.results) {
//                queue.offer(i);
//            }
//            placeholder = apiResult.placeholder;
//        }
//
//    }
//
//
//    final class APIResult {
//        public List<Integer> results;
//        public String placeholder;
//
//        protected APIResult(List<Integer> results, String placeholder) {
//            this.results = results;
//            this.placeholder = placeholder;
//        }
//    }
//}
