/*
 * 此暴力方法超时
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> copyNums = new ArrayList<>();
          Set<List<Integer>> unary = new HashSet<>();
          for(int i:nums)
              copyNums.add(i);
          for(int i = 0;i<copyNums.size();i++) {
              for (int j = i + 1; j < copyNums.size(); j++) {
                  for (int k = j + 1; k < copyNums.size(); k++) {
                      if (copyNums.get(i) + copyNums.get(j) + copyNums.get(k) == 0) {
                          List<Integer> temp = new ArrayList<>();
                          temp.add(nums[i]);
                          temp.add(nums[j]);
                          temp.add(nums[k]);
                          Collections.sort(temp);
                          unary.add(temp);
                          break;
                      }

                  }
              }
          }
        List<List<Integer>> ret = new ArrayList<>(unary);
          return ret;
    }
}