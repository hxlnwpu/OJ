/**
 * 方法1: 动态规划
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int k = 0;
        Boolean[][] dp = new Boolean[length][length];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                dp[i][j] = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++ ) {
                k = j + i;
                if (k >= length)
                    break;
                if (i == 0)
                    dp[j][k] = true;
                else if (i == 1)
                    dp[j][k] = (s.charAt(j) == s.charAt(k));
                else {
                    dp[j][k] = dp[j + 1][k - 1] && (s.charAt(j) == s.charAt(k));
                }
                if (dp[j][k] && (i + 1 > sb.length())) {
                    sb.delete(0,sb.length());
                    for (int q = j; q < k + 1; q++)
                        sb.append(s.charAt(q));
                }
            }
        }
        return sb.toString();

    }
}
/**
 * 方法2
 */
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