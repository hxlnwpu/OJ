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
  * 方法2:动态规划
  */
  class Solution {
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
 
 /**
  * 方法3
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