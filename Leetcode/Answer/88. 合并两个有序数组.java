/**
 * 双指针从后面开始
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0){
            for(int k = 0;k<n;k++)
                nums1[k] = nums2[k];
            return;
        }
        int index = m+n-1;
        int i = m-1;
        int j = n-1;
        while(j>=0&&i>=0)
        {
            if(nums2[j]>=nums1[i]) {
                nums1[index--] = nums2[j];
                j--;
            }
            else
            {
                nums1[index--] = nums1[i];
                i--;
            }
        }
        System.arraycopy(nums2,0,nums1,0,j+1);

    }
}