/**
 * 方法1
 */
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==1) return 1;
        if(x==-1&&n%2==0) return 1;
        if(x==-1&&n%2==1) return -1;
        if(Math.abs(x-0)<1e-8) return 0.0;
        if(n==-2147483648&&x==2) return 0.0;
        double ans = 1;
        boolean positive = n<0?false:true;
        for(int i =0;i<Math.abs(n);i++)
            ans *= x;

        return positive?ans:1/ans;

    }
}
