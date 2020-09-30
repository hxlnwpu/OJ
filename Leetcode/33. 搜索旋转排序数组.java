class Solution {
    public int search(int[] nums, int target) {
         if(nums==null||nums.length==0) return -1;
         if(nums.length==1)
         {
             if(target==nums[0]) return 0;
             else return -1;
         }
         int i  =0;
         while(i<nums.length-1&&nums[i]<nums[i+1]) i++;
         if(i==nums.length-1) return binarySearch(nums,0,nums.length-1,target);
         if(target<nums[0]) return binarySearch(nums,i+1,nums.length-1,target);
         else return binarySearch(nums,0,i,target);

    }
    public static int binarySearch(int[] nums,int left,int right,int target)
    {
        int  mid = left;
        while(left<=right)
        {
            mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return -1;

    }
}