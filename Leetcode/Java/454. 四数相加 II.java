class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                    ans += map1.getOrDefault(-(C[i]+D[j]),0);
                
            }
        }
        return ans;
    }
}