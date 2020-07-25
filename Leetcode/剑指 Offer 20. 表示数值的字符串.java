/**
 * 有限状态机
 */
class Solution {
    public boolean isNumber(String s) {
        Map[] states = {
            new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
            new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
            new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
            new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
            new HashMap<>() {{ put('d', 3); }},                                        // 4.
            new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
            new HashMap<>() {{ put('d', 7); }},                                        // 6.
            new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
            new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == '.' || c == 'e' || c == 'E' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
/**
 * 方法2：
 */
class Solution {
    //char '+' = 43,char '-' = 45,char '.' = 46,char 'e' = 101
    public boolean isNumber(String s) {
        if(s==null)
            return false;
        s = s.trim();
        if(s.isEmpty())
            return false;
        boolean[] match = new boolean[256];
        for(int i = 48; i <= 57; ++i){
            match[i] = true;
        }
        match[46] = true;
        match[101] = true;

        char[] cs = s.toCharArray();
        int i = 0;
        if(cs[0]=='+'||cs[0]=='-'){
            if(cs.length == 1)
                return false;
            ++i;
        }
        if((cs[i]=='.'&&i == cs.length-1)||(cs[i]=='.'&&cs[i+1]=='e')||cs[i]=='e')
            return false;
        
        for(; i < cs.length; ++i){
            int n = (int)cs[i];
            if(!match[n])
                return false;
            if(n == 46)
                match[46] = false;
            if(n == 101){
                if(i == cs.length-1)
                    return false;
                if(cs[i+1] == '.')
                    return false;
                if(cs[i+1]=='+' || cs[i+1] == '-'){
                    if(i+1 == cs.length-1)
                        return false;
                    else 
                        ++i;
                }
                match[101] = false;
                match[46] = false;
            }
        }
        return true;
    }
}
/**
 * 方法3
 */
class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
}
