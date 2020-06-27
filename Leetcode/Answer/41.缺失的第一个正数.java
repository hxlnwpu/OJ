/**
 * 方法1:  时间复杂度:O(NlogN),空间复杂度O(1)
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
       Arrays.sort(nums);
       if(nums[nums.length-1]<=0)
           return 1;
       else
       {
           for(int i = 1;i<nums[nums.length-1];i++)
           {
               if(Arrays.binarySearch(nums, i)<0)
                   return i;
           }
       }
       return nums[nums.length-1]+1;
    }
}
/**
 * 方法2:
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
