class Solution {
    
    /**
     * 是不是有相同的根节点
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean ans = false;
        if(A!=null && B!=null)
        {
            if(A.val == B.val)
                ans = helper(A,B);
            if(!ans)
                ans = isSubStructure(A.left,B);
            if(!ans)
                ans = isSubStructure(A.right,B); 
            
        }
        return ans;
    }
    /**
     * 是否每个节点都相同
     * @param A
     * @param B
     * @return
     */
    public boolean helper(TreeNode A, TreeNode B)
    {
        if(B==null) return true;
        if(A==null) return false;
        if(A.val!=B.val) return false;
        return helper(A.left,B.left)&&helper(A.right,B.right);
    }
}