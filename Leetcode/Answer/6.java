class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
       List<StringBuilder> rows = new ArrayList<>();
       for(int i =0;i<numRows;i++)
           rows.add(new StringBuilder());
       int curRow = 0;
       boolean down = false;
       for(char c:s.toCharArray())
       {
           rows.get(curRow).append(c);
           if(curRow == 0 || curRow == numRows-1) down = !down;
           curRow += down? 1:-1;
       }
       StringBuilder ret  = new StringBuilder();
       for(StringBuilder str:rows)
           ret.append(str);
       return ret.toString();


    }
}