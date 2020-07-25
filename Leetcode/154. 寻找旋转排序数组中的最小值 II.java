class Solution {
    public int findMin(int[] nums) {
                if(nums.length==1) return  nums[0];
        int left = 0,right = nums.length-1,mid=left;
        while(nums[left]>=nums[right])
        {
            if(right-left == 1)
            {
                mid = right;
                break;
            }
            mid = (right+left)/2;
            if(nums[left]==nums[right] && nums[left]==nums[mid])
            {
                int result = nums[left];
                for(int i = left+1;i<=right;i++)
                {
                    if(nums[i]<result)
                    {
                        result=nums[i];
                        return result;
                    }
                        
                }
            }
            if(nums[mid]>=nums[left])
                left = mid;
            else if(nums[mid]<=nums[right])
                right = mid;
        }
        return nums[mid];
    }
}