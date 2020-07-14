/**
 * 回溯法
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(S),0,res);
        return res;


    }
    public void dfs(StringBuilder sb,int index,List<String> res)
    {
        if(index>=sb.length())
        {
            res.add(sb.toString());
            return;
        }
        char ch = sb.charAt(index);
        if(ch>=65 && ch <=90 || ch>=97 &&ch <=122)
        {
            dfs(sb,index+1,res);
            sb.setCharAt(index,(char)(ch ^ 32));
            dfs(sb,index+1,res);
        }
        else
        {
            dfs(sb,index+1,res);
        }
    }
}
