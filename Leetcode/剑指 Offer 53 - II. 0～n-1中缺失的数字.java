class Solution {
    public int missingNumber(int[] nums) {
         int left = 0;
         int right = nums.length-1;
         int mid = 0;
         while(left<=right)
         {
             mid = left+(right-left)/2;
             if(nums[mid]>mid)
                 right = mid-1;
             else if(nums[mid]==mid)
                 left = mid+1;
         }
         return left;

    }
}