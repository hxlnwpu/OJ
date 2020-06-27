/**
 * 方法1
 */
class Solution {
    public boolean isMatch(String text, String pattern) {
         //递归回溯结束点
         if (pattern.isEmpty()) {
             return text.isEmpty();
         }
         boolean first_match = (!text.isEmpty() &&
                 (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
 
         //如果pattern长度大于2并且第二位是*，这一步isMatch3(text, pattern.substring(2)可以判定用到*匹配零个前字符isMatch3(text, pattern.substring(2)
         if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
             //这个匹配判定用到*匹配零个前字符
             return (isMatch(text, pattern.substring(2)) ||
                     //这个匹配判定*代表n个字符
                     (first_match && isMatch(text.substring(1), pattern)));
         } else {
             //判定第二位不是*的情况都移位判定，每回递归只判断第一位，直到空
             return first_match && isMatch(text.substring(1), pattern.substring(1));
         }
     }
 }

 /**
  * 方法2
  */
  class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
 