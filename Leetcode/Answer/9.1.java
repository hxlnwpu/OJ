class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        if(reverse.equals(s))
            return true;
        else
            return false;
    }
}