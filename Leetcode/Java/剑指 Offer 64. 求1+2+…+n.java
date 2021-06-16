
/**
 * 方法1
 */
class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
/**
 * 方法2
 */
class Solution {
    public int sumNums(int n) {
            return IntStream.range(1,n+1).sum();
        }
    }