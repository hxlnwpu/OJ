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
