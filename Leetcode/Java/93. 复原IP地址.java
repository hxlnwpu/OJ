class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];
    public List<String> restoreIpAddresses(String s) {
       int length = s.length();
       if(length<4||length>12) return ans;
       dfs(s,0,0);
       return ans;
    }
    public void dfs(String s,int segId,int segStart)
    {
        if(segId==SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT - 1)
                        sb.append('.');
                }
                ans.add(sb.toString());
            }
            return;
        }
        if(segStart==s.length())
        {
            return;
        }
        if(s.charAt(segStart)=='0'){
            segments[segId] = 0;
            dfs(s,segId+1,segStart+1);
        }
        int addr = 0;
        for(int segEnd = segStart;segEnd<s.length();segEnd++)
        {
            addr = addr*10+(s.charAt(segEnd)-'0');
            if(addr>0&&addr<=0xFF)
            {
                segments[segId] = addr;
                dfs(s,segId+1,segEnd+1);
            }
            else
            {
                break;
            }
        }
    }
}