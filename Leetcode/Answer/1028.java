/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // 遍历S的全局指针
    private int index = 0;

    public TreeNode recoverFromPreorder(String S) {
        if (S.isEmpty()) return null;
        return buildBinaryTree(S.toCharArray(), 0);
    }

    public TreeNode buildBinaryTree(char[] ss, int depth) {

        // 判定当前节点是否是null
        if (index + depth >= ss.length || isNullPointer(ss, depth)) return null;

        // index指针跳过depth个'-'，指向下一个节点的开始位置
        index += depth;

        // 左右子树递归
        TreeNode root = new TreeNode(getValue(ss));
        root.left = buildBinaryTree(ss, depth + 1);
        root.right = buildBinaryTree(ss, depth + 1);

        // 返回当前节点
        return root;
    }


    // 获取当前节点的val值，由于可能有多位，需要遍历一下
    public int getValue(char[] ss) {
        int value = 0;
        while (index < ss.length && ss[index] != '-') {
            value = value * 10 + (ss[index] - '0');
            index ++;
        }
        return value;
    }

    // 判断当前位置的节点是不是null
    public boolean isNullPointer(char[] ss, int depth) {
        for (int i = index; i < index + depth; i ++) {
            if (ss[i] != '-') return true;
        }
        return false;
    }
}
