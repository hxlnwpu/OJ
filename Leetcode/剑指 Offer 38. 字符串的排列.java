/**
 * 回溯法
 */
class Solution {
    List<String> ans = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
          c = s.toCharArray();
          dfs(0);
          return ans.toArray(new String[ans.size()]);
        
    }
    void dfs(int x)
    {
        if(x == c.length-1)
        {
            ans.add(String.valueOf(c));
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x;i<c.length;i++)
        {
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }
    void swap(int a,int b)
    {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}