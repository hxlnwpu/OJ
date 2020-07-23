class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
               if(matrix == null) return null;
               List<Integer> ans = new ArrayList<>();
        if(matrix.length==0) return ans;
        if(matrix[0].length==0) return ans;
        int left=0,right=matrix[0].length-1,top=0,bottom = matrix.length-1;
        while(left<=right&&top<=bottom)
        {
            //打印行
            for(int col = left;col<=right;col++)
                ans.add(matrix[top][col]);
            //打印列
            for(int row = top+1;row<=bottom;row++)
                ans.add(matrix[row][right]);
            if(left<right&&top<bottom)
            {
                for(int col = right-1;col>left;col--)
                    ans.add(matrix[bottom][col]);
                for(int row = bottom;row>top;row--)
                    ans.add(matrix[row][left]);
            }
            left++;
            right--;
            bottom--;
            top++;
        }
         return ans;
    }
}