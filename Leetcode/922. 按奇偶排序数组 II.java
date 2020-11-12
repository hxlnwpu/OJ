/**
 * 方法1
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int index = 0,i = 0,j =1;
        while(index<A.length)
    {
        if(A[index]%2==1)
        {
            ans[j] = A[index];
            j = j+2;
        } 
        else
        {
            ans[i] = A[index];
            i = i+2;
        } 
        index++;
    }
        return ans;
    }
}

/**
 * 方法2：双指针
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }   
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}