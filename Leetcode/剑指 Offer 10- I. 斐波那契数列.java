/**
 * 方法1：递归
 */
class Solution {
    public int fib(int n) {
        if(n <= 0 ) return 0;
        if(n==1) return 1;
        return  fib(n-2)+fib(n-1);
    }
}
/**
 * 迭代法（或者叫动态规划？）
 */
class Solution {
    public int fib(int n) {
        if(n <= 0 ) return 0;
        if(n==1) return 1;
        int fn=0,fnMinusOne=1,fnMinusTwo = 0;
        for(int i = 2;i<=n;i++)
        {
            fn = (fnMinusOne+fnMinusTwo)%1000000007;
            fnMinusTwo = fnMinusOne;
            fnMinusOne = fn;
        }
        return fn;
    }
}