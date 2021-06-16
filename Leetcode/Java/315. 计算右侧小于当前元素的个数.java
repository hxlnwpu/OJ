/**
 * 方法1：暴力 超时
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
              List<Integer> ans  = new ArrayList<>();
         for(int i = 0;i<nums.length;i++)
         {
             int num = 0;
             for(int j = nums.length-1;j>i;j--)
             {
                 if(nums[j]<nums[i])
                     num++;
             }
             ans.add(num);
         }
         return ans;
    }
}
/**
 * 方法2：归并排序+索引数组
 */
class Solution {
    private int[] temp;
 private int[] counter;
 private int[] indexes;

 public List<Integer> countSmaller(int[] nums) {
     List<Integer> res = new ArrayList<>();
     int len = nums.length;
     if (len == 0) {
         return res;
     }
     temp = new int[len];
     counter = new int[len];
     indexes = new int[len];
     for (int i = 0; i < len; i++) {
         indexes[i] = i;
     }
     mergeAndCountSmaller(nums, 0, len - 1);
     for (int i = 0; i < len; i++) {
         res.add(counter[i]);
     }
     return res;
 }

 /**
  * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
  *
  * @param nums
  * @param l
  * @param r
  */
 private void mergeAndCountSmaller(int[] nums, int l, int r) {
     if (l == r) {
         // 数组只有一个元素的时候，没有比较，不统计
         return;
     }
     int mid = l + (r - l) / 2;
     mergeAndCountSmaller(nums, l, mid);
     mergeAndCountSmaller(nums, mid + 1, r);
     // 归并排序的优化，同样适用于该问题
     // 如果索引数组有序，就没有必要再继续计算了
     if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
         mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
     }
 }

 /**
  * [l, mid] 是排好序的
  * [mid + 1, r] 是排好序的
  *
  * @param nums
  * @param l
  * @param mid
  * @param r
  */
 private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
     // 3,4  1,2
     for (int i = l; i <= r; i++) {
         temp[i] = indexes[i];
     }
     int i = l;
     int j = mid + 1;
     // 左边出列的时候，计数
     for (int k = l; k <= r; k++) {
         if (i > mid) {
             indexes[k] = temp[j];
             j++;
         } else if (j > r) {
             indexes[k] = temp[i];
             i++;
             // 此时 j 用完了，[7,8,9 | 1,2,3]
             // 之前的数就和后面的区间长度构成逆序
             counter[indexes[k]] += (r - mid);
         } else if (nums[temp[i]] <= nums[temp[j]]) {
             indexes[k] = temp[i];
             i++;
             // 此时 [4,5, 6   | 1,2,3 10 12 13]
             //           mid          j
             counter[indexes[k]] += (j - mid - 1);
         } else {
             // nums[indexes[i]] > nums[indexes[j]] 构成逆序
             indexes[k] = temp[j];
             j++;
         }
     }
 }
}
/**
 * 方法3：离散化树状数组
 */
class Solution {
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>(); 
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
}