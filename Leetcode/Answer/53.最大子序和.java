/**
 * 方法1
 */
class Solution {
    public int maxSubArray(int[] nums) {
   if (nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
      for(int i =0;i<nums.length;i++)
      {
          int temp= nums[i];
          max = Math.max(temp,max);
          for(int j = i+1;j<nums.length;j++)
          {
                  temp += nums[j];
              max = Math.max(temp,max);
          }
      }
      return max;
    }
}

/**
 * 方法2
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        int max = Arrays.stream(nums).max().getAsInt(),pre = 0;
        for(int i:nums)
        {
            pre = Math.max(pre+i,i);
            max = Math.max(pre,max);
        }
      return max;
    }
}