class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
        {
            return new int[0];
        }
        int rows = matrix.length,cols = matrix[0].length;
        int index = 0,top =0,bottom = rows-1,left=0,right= cols-1;
        int elemNums = matrix.length*matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        int[] result = new int[elemNums];
        while(left<=right && top<=bottom)
        {
            for(int col = left;col <= right;col++)
            {
                ret.add(matrix[top][col]);
            }
            for(int row = top+1;row<=bottom;row++)
            {
                ret.add(matrix[row][right]);
            }
            if(left<right && top<bottom)
            {
                for(int col = right -1 ;col > left;col--)
                {
                    ret.add(matrix[bottom][col]);
                }
                for(int row = bottom;row>top;row--)
                {
                    ret.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        for(Integer i:ret)
            result[index++] = i;
        return result;
    }
}