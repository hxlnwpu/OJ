/**
 * 模拟乘法运算
 */
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals((num2))) return "0";
        int  m = num1.length();
        int n = num2.length();
        if(m==0||n==0) return null;
        String ans = "0";
        List<String> sum = new ArrayList<>();
        for(int i = n-1;i>=0;i--)
        {
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for(int j = n-1;j>i;j--)
                sb.append(0);
            int y = num2.charAt(i)-'0';
            for(int j = m-1;j>=0;j--)
            {
                int x = num1.charAt(j)-'0';
                int product = x * y + add;
                sb.append(product%10);
                add = product/10;
            }
            if(add!=0)
                sb.append(add%10);
            ans = addString(ans,sb.reverse().toString());
        }
        return ans;
    }
    public String addString(String num1,String num2)
    {
        int i = num1.length()-1,j=num2.length()-1,add=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0||add!=0)
        {
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            int result = x + y +add;
            sb.append(result%10);
            add = result/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}
/**
 * 方法2
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}