/**
 * 方法1：暴力
 */
class Soultion {
    public int findLength(int[] A, int[] B) {
        int sum = 0;
        int max = 0;
        int start = 0;
        for (int i = 0, j = start; j < A.length && i < A.length; j++, i++) {
            if (A[i] == B[j]) {
                sum++;
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
            if (j == A.length - 1) {
                j = start;
                start++;
                i = -1;
                sum = 0;
            }
            if (A.length - start <= max)
                break;
        }
        sum = 0;
        start = 0;
        for (int i = 0, j = start; j < A.length && i < A.length; j++, i++) {

            if (B[i] == A[j]) {
                sum++;
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
            if (j == A.length - 1) {
                j = start;
                start++;
                i = -1;
                sum = 0;
            }
            if (A.length - start <= max)
                break;
        }
        return max;
    }
}
/**
 * 方法2：动态规划
 */
/**
 * 滑动窗口
 */
