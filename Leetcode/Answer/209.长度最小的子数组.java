/**
 * 方法1：暴力
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        if(Arrays.stream(nums).sum()<s) return 0;
        int ret = nums.length,i=0,j=0;
        for(i = 0;i<nums.length;i++)
        {
            int temp = nums[i];
            int num = 1;
            for(j = i+1;j<nums.length;j++)
            {
                if(temp<s)
                {
                    temp+=nums[j];
                    num += 1;
                }
                else
                    break;
            }
            if(temp>=s)
               ret = Math.min(num,ret);
        }
        return ret;
    }
}
/**
 * 方法2：前缀和 + 二分查找（n*logn）
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; 
        // 为了方便计算，令 size = n + 1 
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
/**
 * 方法3：双指针
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}