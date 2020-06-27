/**
 * 方法1
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
         int[] ret = new int[T.length];
        int flag = 0;
        for(int i =0;i<T.length;i++)
        {
            flag = 0;
            for(int j = i+1;j<T.length;j++)
            {
                if(T[j]>T[i])
                {
                    ret[i] = j-i;
                    flag = 1;
                    break;
                }
                else
                    continue;
            }
            if(flag == 0)
                ret[i]= 0;
        }
        return ret;

    }
}
/**
 * 方法2
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
          int length = T.length;
          int[] ans = new int[length];
          int temperature = 0;
          Deque<Integer> stack = new LinkedList<>();
          for(int i=0;i<length;i++)
          {
              temperature = T[i];
              while(!stack.isEmpty() && temperature>T[stack.peek()])
              {
                  int preIndex = stack.pop();
                  ans[preIndex] = i - preIndex;
              }
              stack.push(i);
          }
          return ans;
    }
}