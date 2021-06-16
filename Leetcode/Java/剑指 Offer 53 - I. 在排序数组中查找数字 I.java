/**
 * 方法1
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        int index = 0;
        int ans = 0;
        while(index<nums.length&&nums[index]!=target) index++;
        if(index>=nums.length) return 0;
        while(index<nums.length&&nums[index++]==target) ans++;
        return ans;
    }
}
/**
 * 方法2
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        int index = Arrays.binarySearch(nums,target);
        if(index<0) return 0;
        int ans = 0;
        int i = index;
        int j = index;
        while(i>=0&&nums[i]==target) i--;
        while(j<nums.length&&nums[j]==target) j++;
        return j-i-1;
    }
}

/**
 * 方法3
 */
class Solution {
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
