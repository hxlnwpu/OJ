/**
 * 方法1
 */
class Solution {
    public String intToRoman(int num) {
              int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        while(num!=0)
        {
            for(int i =0;i<values.length;i++)
            {
                if(num>=values[i])
                {
                    num -= values[i];
                    sb.append(symbols[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
/**
 * 方法2：硬编码
 */
class Solution {
    public String intToRoman(int num) {
    
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
    
}


