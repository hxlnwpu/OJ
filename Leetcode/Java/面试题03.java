/**
 * 方法1
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
          Set<Integer> unaryNums = new HashSet<>();
        for(int i:nums)
        {
            if(unaryNums.contains(i))
                return i;
            else
                unaryNums.add(i);
        }
        return 0;
    }
}
/**
 * 方法2
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
         int temp = 0;
         for(int i =0;i<nums.length;i++)
         {
             if(nums[i] == i)
                 continue;
             else
             {
                 if(nums[i] == nums[nums[i]])
                     return nums[i];
                 else 
                 {
                     temp = nums[i];
                     nums[i] = nums[temp];
                     nums[temp] = temp;
                 }
             }
         }
         return 0;
    }
}