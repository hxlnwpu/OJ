/**
 * 方法1
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        String[] str = s.trim().split(" ");
        int length = str.length;
        return str[length-1].length();  
    }
}
/**
 * 方法2
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        int right = s.length()-1;
        int ans = 0;
        while(right>=0&&s.charAt(right)==' ') right--;
        if(right<0) return 0;
        while(right>=0 && s.charAt(right)!=' ')
        {
            ans++;
            right--;
        }
        return ans;
    }
}