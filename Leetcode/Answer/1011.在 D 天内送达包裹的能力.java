class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Integer.MAX_VALUE;
        while(left < right)
        {
           int  mid = left + (right - left)/2;
           if(canShip(weights,D,mid))
           {
               right = mid;
           }
           else{
               left = mid+1;
           }
        }
        return left;
    }
    private boolean canShip(int[] weights, int D,int k)
    {
        int cur = k;
        for(int weight:weights)
        {
            if(weight>k) return false;
            if(cur<weight) 
            {
               
               D--;
               cur = k; 
            }
               cur -= weight;      
        }
        return D >0;
    }
}