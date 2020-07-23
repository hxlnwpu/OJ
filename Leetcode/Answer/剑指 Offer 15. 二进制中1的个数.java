/**
 * 方法1：库函数
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
               int ans = 0;
        String s = Integer.toBinaryString(n);
        for(int i = 0;i<s.length();i++)
            if(s.charAt(i)=='1')
                ans++;
            return ans;
            
    }
}
/** 
 * 方法2：循环移位
*/
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}