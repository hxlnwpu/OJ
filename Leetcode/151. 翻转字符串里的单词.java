class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int end = -1;//指向拷贝后数组的最后一个元素，思路来自于partition函数的相同写法。
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' || (end != -1 && array[end] != ' ')) {
                if (i != ++end) {
                    array[end] = array[i];
                }
            } 
        }
        if (end != -1 && array[end] == ' ') end--;
        
        reverse(array, 0, end);
        int l = 0, r = 0;
        while (l <= end) {
            while (r <= end && array[r] != ' ') r++;
            reverse(array, l, r - 1);
            l = ++r;
        }
       
        return String.valueOf(array, 0, end + 1);
    }

    void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
