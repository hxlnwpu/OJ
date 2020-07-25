class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
    if(k==0) return  new int[0];
        if(shorter==longer)
          {
              int[] ans = new int[1];
              ans[0] = k*shorter;
              return ans;
          }
          int[] ans = new int[k+1];
          for(int i = 0;i<=k;i++)
          {
              ans[i] = i*longer + (k-i)*shorter;
          }
          return ans;
    }
}