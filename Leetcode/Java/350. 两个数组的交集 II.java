/**
 * 方法1：HashMap
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
             if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums1)
            map.put(num,map.getOrDefault(num,0)+1);
        int[] intersection = new int[nums1.length];
        int index = 0;
        for(int num:nums2)
            if(map.getOrDefault(num,0)>0)
            {
                intersection[index++] = num;
                if(map.getOrDefault(num,0)-1>0)
                    map.put(num,map.getOrDefault(num,0)-1);
                else
                    map.remove(num);
            }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
/**
 * 方法2：排序后同时扫描
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       int index = 0;
       int[] ret = new int[Math.min(nums1.length,nums2.length)];
       for(int i =0,j=0;i<nums1.length&&j<nums2.length;)
       {
           if(nums1[i]<nums2[j])
               i++;
           else if(nums1[i]>nums2[j])
               j++;
           else
           {
               ret[index++] = nums1[i];
               i++;
               j++;
           }
       }
       return Arrays.copyOfRange(ret,0,index);
    }
}