/**
 * 方法1：Java内置二分查找函数
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums,target);
        if(ans>=0) return ans;
        else return Math.max(Math.abs(ans)-1,0);
    }
}
/**
 * 方法2： 二分查找
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
