/**
 * 方法1
 */
class Solution {
    public int strToInt(String str) {
        if(str==null||str.length()==0) return 0;
        int len = str.length();
        int index = 0;
        char[] s = str.toCharArray();
        while(index<len&&s[index]==' ') index++;
        if(index==len) return 0;
        int sign = 1;
        char firstChar = s[index];
        if(firstChar=='+')
        {
            index++;
        }
        else if(firstChar=='-')
        {
            sign = -1;
            index++;
        }
        int res = 0;
        /**
         * res = res*10+(curChar-'0');
         * 所以判断有没有可能越界的时候，如果当前res大于maxValue的1/10，或者res等于MaxVALUE的1/10而且当前char大于7就会越界。

         *  */ 
        while(index<len)
        {
            char curChar = s[index];
            if(curChar>'9'||curChar<'0'){
                break;
            }
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&(curChar>'7')))
            {
                return Integer.MAX_VALUE;
            }
            if(res< Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&(curChar>'8')))
            {
                return Integer.MIN_VALUE;
            }
            res = res*10+sign*(curChar-'0');
            index++;
        }
        return res;
    }
}