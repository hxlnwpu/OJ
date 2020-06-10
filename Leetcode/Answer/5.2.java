class Solution {
    public String longestPalindrome(String s) {
       int[] bound1 = new int[2];
        int[] bound2 = new int[2];
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++)
        {
            bound1 = expandAroundCenter(s,i,i);
            bound2 = expandAroundCenter(s,i,i+1);
            if (bound1[1] - bound1[0] > end - start)
            {
                start = bound1[0];
                end = bound1[1];
            }
            if (bound2[1] - bound2[0] > end - start)
            {
                start = bound2[0];
                end = bound2[1];
            }
        }
        if (s.length()>0)
           return s.substring(start,end+1);
        else
           return "";
    }
    public static int[] expandAroundCenter(String s,int left,int right)
    {
        int[] bound = new int[2];
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right))
        {
            left -= 1;
            right += 1;
        }
        bound[0] = left+1;
        bound[1] = right-1;
        return  bound;
    }
}