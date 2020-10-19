/**
 * 方法1
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s1 = get(S);
        String s2 = get(T);
        if(s1==null&&s2==null)  return true;
        if(s1==null||s2==null) return false;
        else return s1.equals(s2);
    }
    public String get(String s)
    {
        if(s==null) return null;
        if(s==" ") return " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i)!='#') sb.append(s.charAt(i));
            else 
            {
                if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}
/**
 * 方法2：双指针
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
