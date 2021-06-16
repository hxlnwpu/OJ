/**
 * 方法1
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
         if(nums==null||nums.length==0) return new int[]{-1,-1};
         int index = binarySearch(nums,0,nums.length-1,target);
         if(index==-1) return new int[]{-1,-1};
         int left = index;
         int right = index;
         while(left>=0&&nums[left]==target)
             left--;
         while(right<nums.length&&nums[right]==target) right++;
         return new int[]{left+1,right-1};
         
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
/**
 * 方法2：
 */
class Solution {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}