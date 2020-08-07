/**
 * 方法1
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s==null||s.length()==0) return 0;
       if(s.length()==1) return 1;
       int max = 0;
       char[] c = s.toCharArray();
        for (int i = 0; i<s.length() ; i++) {
            int count = 1;
            Set<Character> set = new HashSet<>();
            set.add(c[i]);
            max = Math.max(max,count);
            for(int j = i+1;j<s.length();j++)
            {
                if(!set.contains(c[j]))
                {
                    set.add(c[j]);
                    count++;
                    max = Math.max(max,count);
                }
                else
                {
                    
                    break;
                }
                    
            }
        }
        return max;
    }
}