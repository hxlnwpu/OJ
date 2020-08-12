/**
 * 方法1：数学方法
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}

/**
 * 方法2：模拟法
 */
class Solution {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
           list.add(i);
        }
        int idx = 0;
        while(n>1)
        {
            idx = (idx+m-1)%n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
