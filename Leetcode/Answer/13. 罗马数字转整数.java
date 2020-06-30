/**
 * 方法1
 */
class Solution {
    public int romanToInt(String s) {
        char[] luoma = s.toCharArray();
        int num = 0;
        for(int i =0;i<luoma.length;i++)
        {
            char c = luoma[i];
            switch(c)
            {
                case 'I':
                    if(i+1<luoma.length && (luoma[i+1]=='V'||luoma[i+1]=='X'))
                        num += (luoma[++i]=='V'?4:9);
                    else
                        num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if(i+1<luoma.length && (luoma[i+1]=='L'||luoma[i+1]=='C'))
                        num += (luoma[++i]=='L'?40:90);
                    else
                         num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if(i+1<luoma.length && (luoma[i+1]=='D'||luoma[i+1]=='M'))
                        num += (luoma[++i]=='D'?400:900);
                    else
                        num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}
/**
 * 方法2
 */
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
