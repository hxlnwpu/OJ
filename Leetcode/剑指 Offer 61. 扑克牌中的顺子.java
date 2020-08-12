/**
 * 方法1
 */
class Solution {
    public boolean isStraight(int[] nums) {
       Arrays.sort(nums);
       int index=0;
        while(nums[index]==0)
        {
            index++;
        }
       for(int i = index+1;i<nums.length;i++)
       {
           int temp = nums[i]-nums[i-1];
           if(temp==0)
               return false;
           else if(temp!=1&&temp>index+1)
           {
               return false;
           }
           else if((temp!=1&&temp<=index)&&index>0)
           {
               index--;
           }

           else if(temp!=1&&index<=0)
           {
               return false;
           }
       }
       return true;

    }
}
/**
 * 方法2
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}