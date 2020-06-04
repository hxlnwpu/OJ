class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        float x,y;
        List<Integer> all = new ArrayList<>();
        for(int elem:nums1)
            all.add(elem);
        for(int elem:nums2)
            all.add(elem);
        Collections.sort(all);
        int size = all.size();
        x = all.get(size/2);
        if(all.size()%2 == 0)
        {
            y = all.get(size/2-1);
            return ((x+y)/2);
        }
        else
            return (x);
    }
}