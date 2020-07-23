/**
 * 方法1：  双指针判断奇偶放到新数组中
 */
class Solution {
    public int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0,right = nums.length-1;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]%2==1)
                ans[left++] = nums[i];
            else
                ans[right--] = nums[i];
        }
        return ans;
    }
}
/**
 * 方法2：双指针交换原数组元素
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0,right = nums.length-1;
        int temp = 0;
        while(left<right)
        {
            while(left<right&&nums[left]%2==1) left++;
            while(left<right&&nums[right]%2==0) right--;
            if(left<right)
            {
                temp = nums[left];
                nums[left]=nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}