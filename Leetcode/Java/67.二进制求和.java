class Solution {
    public String addBinary(String a, String b) {
          StringBuffer sb = new StringBuffer();
        int n = Math.max(a.length(),b.length()),carry = 0;
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        for(int i = 0;i<n;i++)
        {
            carry += i < a.length() ? (a.charAt(i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();

    }
}