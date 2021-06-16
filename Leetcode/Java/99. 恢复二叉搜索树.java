/**
 * 方法1
 */
class Solution {
    Map<Integer,TreeNode> map=new HashMap<>();
    List<Integer> list=new ArrayList<>();
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        dfs(root);
        Integer val1=null;
        Integer val2=null;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                val1=list.get(i);
                break;
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)<list.get(i-1)){
                val2=list.get(i);
                break;
            }
        }

        TreeNode t1=map.get(val1);
        TreeNode t2=map.get(val2);
        t1.val=val2;
        t2.val=val1;
    }
    
    void dfs(TreeNode root){
        if(root==null) return;
        map.put(root.val,root);
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}