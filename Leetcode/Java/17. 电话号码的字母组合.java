/**
 * 回溯法
 */
class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits==null||digits.length()==0) return ans;
        Map<Character,Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r','s'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y','z'});
        backtrack(ans,map,digits,0,new StringBuilder());
        return ans;
    }
    public void backtrack(List<String> ans,Map<Character,Character[]> map,String digits,int index,StringBuilder sb)
    {
        if(index==digits.length())
        {
            ans.add(sb.toString());
        }
        else
        {
            char digit = digits.charAt(index);
            Character[] letters = map.get(digit);
            int count = letters.length;
            for(int i =0;i<count;i++)
            {
                sb.append(letters[i]);
                backtrack(ans,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}