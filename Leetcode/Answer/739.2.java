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
}class 739.2 {
    
}