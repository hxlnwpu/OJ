import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 10种排序算法汇总
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = {3, 44, 38, 2, 12, 1, 37, 25, 99, 11, 58, 51, 77};
//        Arrays.sort(nums);
//        int[] ret = nums;
//        int[] ret = bubbleSort(nums);
//        int[] ret = selectionSort(nums);
//        int[] ret = insertionSort(nums);
//        int[] ret = shellSort(nums);
//        int[] ret = mergeSort(nums);
//        int[] ret = quickSort2(nums,0,nums.length-1);
//        int[] ret = heapSort(nums);
//        int[] ret = countingSort(nums);
        int[] ret = RadixSort(nums);
        for(int i:ret)
            System.out.print(i+" ");
    }

    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if(nums.length==0) return nums;
        for(int i = 0;i<nums.length;i++)
            for(int j =0;j<nums.length-i-1;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        return nums;
    }

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums)
    {
        if(nums.length==0) return nums;
        for(int i = 0;i<nums.length;i++)
        {
            int min = i;
            for(int j = i+1;j<nums.length;j++)
            {
                if(nums[j]<nums[min])
                    min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;

        }
        return nums;
    }
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] insertionSort(int[] nums) {
        if(nums.length == 0) return nums;
        int current;
        for(int i = 0;i<nums.length-1;i++)
        {
            current = nums[i+1];
            int preIndex = i;
            while(preIndex>=0 && current<nums[preIndex])
            {
                nums[preIndex+1]= nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
        return nums;
    }

    /**
     * 希尔排序
     * @param nums
     * @return
     */
    public static int[] shellSort(int[] nums) {
        int len  = nums.length;
        int temp,gap = len/2;
        while(gap>0)
        {
            for(int i = gap;i<len;i++)
            {
                temp = nums[i];
                int preIndex = i-gap;
                while(preIndex>=0 && temp<nums[preIndex])
                {
                    nums[preIndex+gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex+gap] = temp;
            }
            gap /= 2;
        }
        return nums;
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {
        if(nums.length<2) return nums;
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 归并排序，将两段排好序的数组结合成一个排序数组
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left,int[] right)
    {
        int[] result = new int[left.length+right.length];
        for(int index = 0,i=0,j=0;index<result.length;index++)
        {
            if(i>=left.length)
                result[index] = right[j++];
            else if(j>=right.length)
                result[index]= left[i++];
            else if(left[i]>right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;

    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] nums,int start,int end) {
        if(nums.length <1 || start < 0 || end>=nums.length || start>end) return null;
        int smallIndex = partition(nums,start,end);
        if (smallIndex >start)
            quickSort(nums,start,smallIndex-1);
        if(smallIndex < end)
            quickSort(nums,smallIndex+1,end);
        return nums;
    }
    public static int partition(int[] nums, int start, int end)
    {
        int pivot = (int) (start+Math.random()*(end-start+1));
        int smallIndex = start-1;
        swap(nums,pivot,end);
        for(int i = start;i<=end;i++)
        {
            smallIndex ++;
            if(i>smallIndex)
                swap(nums,i,smallIndex);
        }
        return smallIndex;
    }
    public static void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

    /**
     * 快速排序，易理解版
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int[] quickSort2(int[] nums,int left,int right)
    {
        if(nums.length==0||nums==null) return null;
        if(left>=right)  return null;
        int low=left,high=right,temp,pivot= nums[left];
        while(low<high)
        {
            while(low<high && nums[high]>=pivot)
                high--;
            while(low<high && nums[low]<=pivot )
                low++;
            if(low<high)
            {
                temp = nums[low];
                nums[low] = nums[high];
                nums[high]=temp;
            }
        }
        nums[left] = nums[low];
        nums[low] = pivot;
        quickSort2(nums,left,low-1);
        quickSort2(nums,low+1,right);
        return nums;
    }

    /**
     * 堆排序
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
        return arr;
    }
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 计数排序
     * @param nums
     * @return
     */
    public static int[] countingSort(int[] nums) {
        if(nums.length == 0) return nums;
        int bias,min = nums[0],max = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            if(nums[i]>max)
                max = nums[i];
            if(nums[i]<min)
                min = nums[i];
        }
        bias = 0-min;
        int[] bucket = new int[max-min+1];
        Arrays.fill(bucket,0);
        for(int i =0;i<nums.length;i++)
            bucket[nums[i]+bias]++;
        int index = 0,i=0;
        while(index<nums.length)
        {
            if(bucket[i]!=0)
            {
                nums[index] = i-bias;
                bucket[i]--;
                index++;
            }
            else
                i++;
        }
        return nums;
    }

    /**
     * 桶排序
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    /**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
