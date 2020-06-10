class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int tempSum = 1;
        for(int i =0;i<nums.length;i++)
        {
            tempSum = 1;
            for(int j = 0;j<nums.length;j++)
            {
                if(i !=j)
                {
                    tempSum *= nums[j];
                }
            }
            ret[i] = tempSum;
        }
        return ret;
    }
}