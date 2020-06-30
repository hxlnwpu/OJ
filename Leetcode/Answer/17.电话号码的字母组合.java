/**
 * 递归
 */
class Solution {

    List<String> ans = new ArrayList();

    // 初始化 map
    Map<Character, String> map = new HashMap(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    void backtrack(String word, String digits){
        // 如果 到达最底层了， 就找到一个word
        if(digits.length() == 0){
            ans.add(word);
        }else{
            // 取出当前这一层的数字
            char number = digits.charAt(0);
            // 取出当前这一层的字母集
            String letters = map.get(number);
            // 分身到各个字母上，同时也就去了下一层
            for(int i = 0; i<letters.length(); i++){
                backtrack(word + letters.charAt(i), digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        // 从第一层开始
        backtrack("", digits);
        return ans;
    }
}