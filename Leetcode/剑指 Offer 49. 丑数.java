class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;
       int[] ans = new int[n];
       int a =0;  //2
       int b = 0; //3
       int c = 0; //5
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        for(int i = 3;i<n;i++)
        {
            while(ans[a]*2<=ans[i-1]) a++;
            while(ans[b]*3<=ans[i-1]) b++;
            while(ans[c]*5<=ans[i-1]) c++;
            ans[i] = Math.min(Math.min(ans[a]*2,ans[b]*3),ans[c]*5);
        }
        return ans[n-1];
    }

}