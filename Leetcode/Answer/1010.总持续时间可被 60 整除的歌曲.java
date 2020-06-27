class Solution {
    public int combination(int n, int k){
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;

    }
    public int numPairsDivisibleBy60(int[] time) {
        int length = time.length;
        int count = 0;
        int molecule = 1;
        int[] remainder = new int[60];
        for (int elem : time)
            remainder[elem % 60]++;
        int left = 1, right = 59;
        while (left < right)
            count += remainder[left++] * remainder[right--];
        count += combination(remainder[0],2);
        count += combination(remainder[30],2);
        return count;
    }
}