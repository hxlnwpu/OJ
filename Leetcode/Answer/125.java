class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length() ==1) return true;
        StringBuilder sb= new StringBuilder();
       for(int i =0;i<s.length();i++)
       {
           char ch = s.charAt(i);
           if(Character.isDigit(ch) || Character.isLetter(ch))
              sb.append(ch);
       }
       String news = sb.toString().toLowerCase();
       int left = 0,right = news.length()-1;
       while(left<=right)
       {
           if(!(news.charAt(left++) == news.charAt(right--)))
               return false;
       }
       return true;
    }
}