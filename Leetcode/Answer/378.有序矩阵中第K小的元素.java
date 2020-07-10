/**
 * 调库
 */
class Soultion {
    public int kthSmallest(int[][] matrix, int k) {
        int[] array = new int[matrix.length*matrix[0].length];
        int index = 0;
         for(int i =0;i<matrix.length;i++)
         {
             for(int e:matrix[i])
             {
                 array[index++] = e;
             }
         }
         Arrays.sort(array);
         return array[k-1];
    }
}
