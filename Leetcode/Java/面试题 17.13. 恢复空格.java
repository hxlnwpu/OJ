/**
 * 方法1：字符串哈希
 */
class Solution {
    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public int respace(String[] dictionary, String sentence) {
        Set<Long> hashValues = new HashSet<Long>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    public long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }
}
/**
 * 方法2：Trie + 动态规划
 */
class Solution {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;
    
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }
}
/**
 * 方法3：自己实现，65/71测例通过
 */
class Solution {
    public int respace(String[] dictionary, String sentence) {
               if(sentence.length()==0) return 0;  
              int ans = sentence.length();
              StringBuilder sb = new StringBuilder(sentence);
              Arrays.sort(dictionary, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // 忽略大小写排序:
                    return s1.length()<s2.length()?1:-1;
                }
             });
              for(String word:dictionary)
              {
                  int index = sb.indexOf(word);
                  while(index!=-1)
                  {
                      ans -= word.length();
                      sb.delete(index,index+word.length());
                      index = sb.indexOf(word);
                  }
              }
              return ans;
        }
    }