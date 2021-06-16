class Solution {
    public String sortString(String s) {
      int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        boolean left = true;
        while(sb.length()<s.length())
        {
            if(left==true)
            {
                for (int i = 0; i < bucket.length ; i++) {
                    if(bucket[i]>0){
                        sb.append((char) (i + 'a'));
                        bucket[i]--;
                    }
                }
                left = false;
            }
            else
            {
                for (int i = bucket.length-1; i >=0 ; i--) {
                    if(bucket[i]>0){
                        sb.append((char) (i + 'a'));
                        bucket[i]--;
                    }
                }
                left = true;
            }
        }
        return sb.toString();
    }
}