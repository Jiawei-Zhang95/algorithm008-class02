/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 思路：先复制nums1，然后用双指针将元素依次加入nums1中 nums1为输出数组
         */

        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        // 设置两个数组的指针
        int p1 = 0, p2 = 0;

        // 设置输出数组的指针
        int p = 0;

        while (p1 < m && p2 < n) {
            nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
        }

        // 如果nums1还没走完，把剩余元素加进来。
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        }

    }
}
// @lc code=end
