/**
 * 方法1
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int[][] temp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = numbersOf1(arr[i]);
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = temp[i][0];
        }
        return ans;
    }

    public int numbersOf1(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}
/**
 * 方法2
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}