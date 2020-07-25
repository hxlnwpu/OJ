/**
 * 递归
 */
class Solution {
    public double myPow(double x, int n) {
        long num = n;
		return pow(x,num);
    }
    public double pow(double x,long n) {
		if (n == 0) {
			return 1;// 假定0的0次方也为1
		}
		if(n == 1) {
			return x;
		}
		if(n > 1) {
			double result = pow(x,n>>1);// x>>1就是exp/2，但是位运算效率更高
			result = result * result;
			if((n & 1) == 1) {// n & 1 可以判断奇偶，=1为奇数，比%效率更高
				result = result * x;
			}
			return result;
		}
		if(n < 0) {
			n = -n;
			double result = pow(x,n);
			return 1/result;
		}
		throw new IllegalArgumentException("出现异常！");
	}
}
/**
 * 方法2：快速幂法
 */
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
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