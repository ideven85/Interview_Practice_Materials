package com.cleo.algorithms.trees;

public class ConstructBinaryTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }
    public TreeNode buildBT(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int data = preOrder[preStart];
        TreeNode cur = new TreeNode(data); int offset = inStart;
        for(; offset < inEnd; offset++){ if(inOrder[offset] == data)
            break; }
        cur.left = buildBT(preOrder, preStart + 1, preStart + offset - inStart, inOrder, inStart, offset - 1); cur.right = buildBT(preOrder, preStart + offset - inStart + 1, preEnd, inOrder, offset + 1, inEnd); return cur;
    }
}
