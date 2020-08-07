class Solution {
    public char firstUniqChar(String s) {
        if(null==s||s.length()==0) return ' ';
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] c = s.toCharArray();
        for(int i =0;i<s.length();i++)
        {
            int count = map.getOrDefault(c[i],0);
            map.put(c[i],count+1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) return entry.getKey();
        }
        return ' ';
    }
}