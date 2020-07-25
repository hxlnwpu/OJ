/**
 * 方法1：二分查找
 */
class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
/**
 * 方法2：官方方法
 */
class Solution {
    public int minArray(int[] numbers) {
           if(numbers.length==1) return  numbers[0];
           int left = 0,right = numbers.length-1,mid=left;
           while(numbers[left]>=numbers[right])
           {
               if(right-left == 1)
               {
                   mid = right;
                   break;
               }
               mid = (right+left)/2;
               if(numbers[left]==numbers[right] && numbers[left]==numbers[mid])
               {
                   int result = numbers[left];
                   for(int i = left+1;i<=right;i++)
                   {
                       if(numbers[i]<result)
                       {
                           result=numbers[i];
                           return result;
                       }
                           
                   }
               }
               if(numbers[mid]>=numbers[left])
                   left = mid;
               else if(numbers[mid]<=numbers[right])
                   right = mid;
           }
           return numbers[mid];
   
       }
   }
   