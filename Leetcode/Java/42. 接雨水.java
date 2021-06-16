/**
 * 方法1：暴力
 */
class Solution {
    public int trap(int[] height) {
      int ans = 0;
      int left = 0;
      int right = 0;
        for (int i = 0; i < height.length; i++) {
            left = findleftMax(height,i);
            right = findRightMax(height,i);
            //每个元素储存的水量等于 两边最大值的最小值减去当前高度
            if(left>height[i]&&right>height[i]) ans+= Math.min(left,right)-height[i];
        }
        return ans;
    }
    //找左边最大值
    private static int findleftMax(int[] nums,int index)
    {
        int max = nums[index];
        for (int i = 0; i < index ; i++) {
            max = Math.max(nums[i],max);
        }
        return max;
    }
    //找右边最大值
    private static int findRightMax(int[] nums,int index)
    {
        int max = nums[index];
        for (int i = nums.length-1; i > index; i--) {
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
/**
 * 方法2：动态规划
 */
class Solution{
public int trap(int[] height) {
    if (height == null || height.length == 0)
        return 0;
    int ans = 0;
    int size = height.length;
    int[] left_max = new int[size];
    int[] right_max = new int[size];
    left_max[0] = height[0];
    for (int i = 1; i < size; i++) {
        left_max[i] = Math.max(height[i], left_max[i - 1]);
    }
    right_max[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
        right_max[i] = Math.max(height[i], right_max[i + 1]);
    }
    for (int i = 1; i < size - 1; i++) {
        ans += Math.min(left_max[i], right_max[i]) - height[i];
    }
    return ans;
}
}

/**
 * 方法4：双指针
 */
class Solution {
    public int trap(int[] height) {
      int left = 0, right = height.length - 1;
      int ans = 0;
      int left_max = 0, right_max = 0;
      while (left < right) {
          if (height[left] < height[right]) {
              if (height[left] >= left_max) {
                  left_max = height[left];
              } else {
                  ans += (left_max - height[left]);
              }
              ++left;
          } else {
              if (height[right] >= right_max) {
                  right_max = height[right];
              } else {
                  ans += (right_max - height[right]);
              }
              --right;
          }
      }
      return ans;
  }
  
  }