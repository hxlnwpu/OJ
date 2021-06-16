class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length==0) return new int[0];
        if(k>=length) 
        {
            Arrays.sort(nums);
            int[] ans = new int[1];
            ans[0] = nums[length-1];
            return ans;
        }
        int[] ans = new int[length-k+1];
        for (int i = 0; i < length-k+1; i++) {
            int max = nums[i];
            for(int j = i+1;j<i+k;j++)
            {
                if(nums[j]>max)
                    max = nums[j];
            }
            ans[i] = max;
        }
        return ans;
    }
}
/**
 * 方法2
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if(i >= 0)
                res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }
}