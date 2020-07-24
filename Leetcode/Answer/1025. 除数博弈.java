/**
 * 方法1：数学归纳法分出奇偶
 */
class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}


/**
 * 方法2：瞎写的，反正过了
 */
class Solution {
    public boolean divisorGame(int N) {
        int flag = 0;
        for(int i =1;i<N;)
        {
            if(N%i==0)
            {
                N = N - i;
                flag = 1 - flag;
            }
            else
                i++;
        }
        if(flag==0) return false;
        else return true;
    }
}