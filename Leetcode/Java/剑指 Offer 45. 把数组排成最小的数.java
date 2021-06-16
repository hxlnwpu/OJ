/**
 * 方法1：
 */
class Solution {
    public String minNumber(int[] nums) {
        for(int i = 0;i< nums.length;i++)
            for (int j = i+1; j <  nums.length; j++) {
                if(compare(nums[i],nums[j])==1)
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        StringBuilder ans = new StringBuilder();
        for(int i:nums)
            ans.append(Integer.toString(i));
        return ans.toString();

    }
    public int compare(int a,int b)
    {
        StringBuilder s1 = new StringBuilder(Integer.toString(a)+Integer.toString(b));
        StringBuilder s2 = new StringBuilder(Integer.toString(b)+Integer.toString(a));
        for(int i =0;i<s1.length();i++)
        {
            int a1 = s1.charAt(i);
            int b1 = s2.charAt(i);
            if(a1>b1) return 1;
            else if(a1<b1) return -1;
        }
        return 0;
    }
}
/**
 * 方法2
 */
class Solution {
    public String minNumber(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(nums.length);
        for(int i:nums)
            arrayList.add(i);
        MyComparator comparator = new MyComparator();
       Collections.sort(arrayList,comparator);
        StringBuilder ans = new StringBuilder();
        for(Integer i:arrayList)
            ans.append(i.toString());
        return ans.toString();

    }
    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            StringBuilder s1 = new StringBuilder(o1.toString()+o2.toString());
            StringBuilder s2 = new StringBuilder(o2.toString()+o1.toString());
            for(int i =0;i<s1.length();i++)
            {
                int a1 = s1.charAt(i);
                int b1 = s2.charAt(i);
                if(a1>b1) return 1;
                else if(a1<b1) return -1;
            }
            return 0;
        }
    }
}