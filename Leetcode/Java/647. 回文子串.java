/**
 * 方法1：中心拓展法
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
/**
 * 方法2：暴力
 */
class Solution {
    public int countSubstrings(String s) {
       if(s==null||s.length()==0) return 0;
       int ans = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i; j < s.length() ; j++) {
                String tmp = s.substring(i,j+1);
                String reverse = new StringBuilder(tmp).reverse().toString();
                if(tmp.equals(reverse))  ans++;
            }
        }
        return ans+1;
    }
}
