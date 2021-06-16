/**
 * 方法1
 */
class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
/**
 * 方法2：暴力超时
 */
class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null) return 0;
        int length = s.length();
        if (length <= 1) return 0;
        int ans = 0;
        char[] sc = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i + 1;
                boolean flag = true;
                if (len % 2 == 0) {
                    int count0 = 0;
                    int count1 = 0;
                    int mid = i + len / 2;
                    char first = sc[i];
                    char second = first == '0' ? '1' : '0';
                    for (int k = i; k <= j; k++) {
                        if (k < mid && sc[k] == first) {
                            if (sc[k] == '0') count0++;
                            else if (sc[k] == '1') count1++;
                        } else if (k < mid && sc[k] != first) {
                            flag = false;
                            break;

                        } else if (k >= mid && sc[k] == second) {
                            if (sc[k] == '0') count0++;
                            else if (sc[k] == '1') count1++;
                        } else if (k >= mid && sc[k] != second) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag && count0 == count1)
                        ans++;
                }
            }
        }
        return ans;
    }
}