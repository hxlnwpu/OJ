/**
 * 方法1
 */
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}

/**
 * 方法2
 */
class Solution {
    public int reverse(int x) {
  boolean positive = true;
        if(x < 0) positive = false;
        int r = Math.abs(x);
        String s = String.valueOf(r);
        String reverse = new StringBuffer(s).reverse().toString();
        int result = 0;
        if(positive)
        {
            try{
                result = Integer.parseInt(reverse);
            }catch (Exception e)
            {
                return 0;
            }
        }
        else
        {
            try{
                result = 0 - Integer.parseInt(reverse);
            }catch (Exception e)
            {
                return 0;
            }
        }
        return result;
    }
}
