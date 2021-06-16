class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;;
        if(length==0) return nums;
        int i = 0;
        int j = length-1;
        int[] ans = new int[2];
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                ans[0] = nums[i];
                ans[1] = nums[j];
                break;
            }
            else if(nums[i]+nums[j]<target)
                i++;
            else
                j--;
        }
        return ans;
    }
}