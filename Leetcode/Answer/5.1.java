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