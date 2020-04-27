import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        // init heap from less to most frequent
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> count.get(o1) - count.get(o2));

        for (int n : count.keySet()) {
            heap.add(n);
            System.out.println("after add heap is: " + Arrays.toString(heap.toArray()));
            if (heap.size() > k) {
                // 这个时候新加进来的都是比较少出现的，所以poll掉
                heap.poll();
                System.out.println("after poll heap is: " + Arrays.toString(heap.toArray()));
            }
        }

        int[] topK = new int[heap.size()];
        for (int i = 0; i < topK.length; i++) {
            topK[i] = heap.poll();
        }

        for (int i = 0; i < topK.length / 2; i++) {
            int temp = topK[i];
            topK[i] = topK[topK.length - i - 1];
            topK[topK.length - i - 1] = temp;
        }

        return topK;
    }

}
// @lc code=end
