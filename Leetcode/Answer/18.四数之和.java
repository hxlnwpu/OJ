/**
 * 方法1：双指针
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 4) {
            return ans;
        }
        // 对数组排序，方便遍历和去重。
        Arrays.sort(nums);
        // 当目标值比数组最小四数和还小或者比数组最大四数和还大，表示没有符合条件的四个数。
        if (target < nums[0] + nums[1] + nums[2] + nums[3]
                || target > nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) {
            return ans;
        }
        // 循环固定第一个数，然后循环遍历选择另外三个数。
        for (int i = 0; i < len - 3; i++) {
            // 相同的第一个数只固定一次，避免重复运算。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果 target 小于当前循环能得到的最小和，则跳出循环。
            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            // 如果 target 大于此轮循环的最大和，则继续循环下一个比较大的第一位数。
            if (target > nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                continue;
            }
            // 循环固定第一个数，根据双指针从它之后去选择另外两个数。
            for (int j = i + 1; j < len - 2; j++) {
                // 相同的第一个数只固定一次，避免重复运算。
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 如果 target 小于当前循环能得到的最小四数和，则跳出循环。
                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                // 如果 target 大于此轮循环的最大和，则继续循环下一个比较大的第二位数。
                if (target > nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
                    continue;
                }
                int L = j + 1, R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    // 根据四数之和与 target 大小的比较来移动两指针。
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                        R--;
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else if (sum > target) {
                        R--;
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else {
                        L++;
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
/**
 * 方法2
 */
class Solution{
    public List<List<Integer>> fourSum(int[] nums,int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                       j++;
                    }
                }
            }
        }
        return result;
    }
}