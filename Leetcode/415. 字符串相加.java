class Solution {
    public String addStrings(String num1, String num2) {
        if(num1==null||num2==null)
            return null;
        int cur = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1,j = num2.length()-1;
        while (i>=0||j>=0||add!=0) {
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            cur = x+y+add;
            sb.append(cur%10);
            add = cur/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}