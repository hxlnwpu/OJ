class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int elem:nums){
            if (elem == 0){
                continue;
            }
            else{
                nums[j] = elem;
                j += 1;
            }
        }
        if(j<nums.length){
            for(int k = j;k<nums.length;k++)
            {
                nums[k] = 0;
            }
        }
    }
}