class Solution {
    public int[] dailyTemperatures(int[] T) {
         int[] ret = new int[T.length];
        int flag = 0;
        for(int i =0;i<T.length;i++)
        {
            flag = 0;
            for(int j = i+1;j<T.length;j++)
            {
                if(T[j]>T[i])
                {
                    ret[i] = j-i;
                    flag = 1;
                    break;
                }
                else
                    continue;
            }
            if(flag == 0)
                ret[i]= 0;
        }
        return ret;

    }
}