class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if (s.length()==0)
        {

            return 0;
        }
        if (s.length()==1)
        {

            return 1;
        }
        Set<Character> set = new HashSet<>();
        List<Integer> resultlist = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++)
        {
            max = 1;
            set.clear();
            set.add(s.charAt(i));
            for(int j =i+1;j<s.length();j++)
            {

                Character ch = s.charAt(j);
                if(set.contains(ch))
                {
                    resultlist.add(max);
                    max = 1;
                    break;
                }
                else
                {
                    set.add(ch);
                    max++;
                }
            }
            resultlist.add(max);
        }
        return Collections.max(resultlist);

    }
}