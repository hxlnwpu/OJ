/**
 * 方法1
 */
class Solution {
    public int longestConsecutive(int[] nums) {
 if(nums.length == 1) return 1;
        if(nums.length == 0) return 0;
        List<Integer> numscopy = new ArrayList<>();
        for(int i:nums)
            numscopy.add(i);
        HashSet h = new HashSet(numscopy);
        numscopy.clear();
        numscopy.addAll(h);
        Collections.sort(numscopy);
        int maxlength = 0;
        int templength = 0;
        for(int i =0;i<numscopy.size();i++)
        {
            templength = 1;
            for(int j = i+1;j<numscopy.size();)
            {
                if(numscopy.get(j)-numscopy.get(j-1) == 1)
                {
                    j++;
                    templength++;
                    continue;
                }
                else
                    break;
            }
            if(templength>maxlength)
                maxlength = templength;
        }
        return maxlength;
    }
}

/**
 * 方法2
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
