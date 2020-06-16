public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        int i = 0;
        int j = 0;
        if (length == 0)
            return "";
        if(length == 1)
            return strs[0];
        int minLength = strs[0].length();
        for (String str : strs)
            if (str.length() < minLength)
                minLength = str.length();
        StringBuilder ret = new StringBuilder();
        while(i<minLength)
        {
            char temp = strs[0].charAt(i);
            j = 0;
            for(String str:strs)
            {
                if(str.charAt(i)==temp)
                {
                    j++;
                    continue;
                }
                else
                    break;
            }
            if(j!=length)
                break;
            else
            {
                ret.append(temp);
                i++;
            }

        }
        return ret.toString();

    }
}