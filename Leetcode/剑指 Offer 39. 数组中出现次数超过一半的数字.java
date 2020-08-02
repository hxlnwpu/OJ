/**
 * 方法1
 */
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        int size = nums.length/2;
        for(int i = 0;i<nums.length;i++)
        {
            int n = map.getOrDefault(nums[i],0);
            map.put(nums[i],n+1); 
            if(n+1>size)
                return nums[i];
        }
        return 0;
    }
}
/**
 * 方法2：排序之后找中位数
 */
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}