class Solution {
    public char firstUniqChar(String s) {
        if(null==s||s.length()==0) return ' ';
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] c = s.toCharArray();
        for(int i =0;i<s.length();i++)
        {
            int count = map.getOrDefault(c[i],0);
            map.put(c[i],count+1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) return entry.getKey();
        }
        return ' ';
    }
}
/**
 * 方法2
 */
class Solution {
    public double quickMul(double x, long N) {
        if(N==0) return 1.0;
        double y = quickMul(x,N/2);
        return N%2==0?y*y:y*y*x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return n>0?quickMul(x,N):1/quickMul(x,-N);
    }
}
/**
 * 方法3
 */
class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}