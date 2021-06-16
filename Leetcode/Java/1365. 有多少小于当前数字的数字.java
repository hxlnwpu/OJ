/**
 * 方法1：排序
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums,0,nums.length);
         Arrays.sort(temp);
         Map<Integer,Integer>  map = new HashMap<>();
        for (int i = 0; i <temp.length; i++) {
            if(!map.containsKey(temp[i]))
               map.put(temp[i],i);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }
        return ans;

    }
}
/**
 * 方法2：计数排序
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }
}
