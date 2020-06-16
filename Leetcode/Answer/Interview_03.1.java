class Solution {
    public int findRepeatNumber(int[] nums) {
          Set<Integer> unaryNums = new HashSet<>();
        for(int i:nums)
        {
            if(unaryNums.contains(i))
                return i;
            else
                unaryNums.add(i);
        }
        return 0;
    }
}