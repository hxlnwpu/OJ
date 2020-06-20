class Solution {
    public boolean isMatch(String text, String pattern) {
         //递归回溯结束点
         if (pattern.isEmpty()) {
             return text.isEmpty();
         }
         boolean first_match = (!text.isEmpty() &&
                 (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
 
         //如果pattern长度大于2并且第二位是*，这一步isMatch3(text, pattern.substring(2)可以判定用到*匹配零个前字符isMatch3(text, pattern.substring(2)
         if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
             //这个匹配判定用到*匹配零个前字符
             return (isMatch(text, pattern.substring(2)) ||
                     //这个匹配判定*代表n个字符
                     (first_match && isMatch(text.substring(1), pattern)));
         } else {
             //判定第二位不是*的情况都移位判定，每回递归只判断第一位，直到空
             return first_match && isMatch(text.substring(1), pattern.substring(1));
         }
     }
 }
 