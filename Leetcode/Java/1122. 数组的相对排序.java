/**
 * 方法1
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i <  arr2.length; i++) {
            int count = map.get(arr2[i]);
            for (int j = 0; j < count ; j++) {
                ans[index++] = arr2[i];
            }
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if(!set.contains(arr1[i]))
                temp.add(arr1[i]);
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size() ; i++) {
            ans[index++] = temp.get(i);
        }
        return ans;
    }
}