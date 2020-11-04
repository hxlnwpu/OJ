/**
 * 方法1
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <  arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while(entries.hasNext())
        {
            Map.Entry<Integer, Integer> entry = entries.next();
            set.add(entry.getValue());
        }
        return set.size()==map.size();
        
    }
}