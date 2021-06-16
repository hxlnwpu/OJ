class Solution {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        if(length<=n) return s;
        return new StringBuilder(s.substring(n,length)+s.substring(0,n)).toString();
        
    }
}
