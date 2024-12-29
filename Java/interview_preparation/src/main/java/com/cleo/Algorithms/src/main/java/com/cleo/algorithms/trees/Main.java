package com.cleo.algorithms.trees;


import java.util.*;




public class Main {

    static class Pair{
        TreeNode node;
        int value;

        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    public int goodNodes(TreeNode root) {
        int target = root.val;
        int count=0;
        Queue<Pair> queue = new LinkedList<>();


        queue.add(new Pair(root,Integer.MIN_VALUE));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode current=pair.node;
            int max_so_far= pair.value;

            if(current.val>=max_so_far)
                count+=1;





            if(current.left!=null)
                queue.add(new Pair(current.left,Math.max(current.val,max_so_far)));
            if(current.right!=null)
                queue.add(new Pair(current.right,Math.max(current.val,max_so_far)));

        }
        return count;



    }
    static List<Integer> output = new ArrayList<>();

    public static void printBetweenK1K2(TreeNode root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.val<k1){
            printBetweenK1K2(root.right, k1, k2);
        }else if(root.val>k2){
            printBetweenK1K2(root.left, k1, k2);
        }else{

            printBetweenK1K2(root.left,k1,k2);
            System.out.print(root.val+ " ");

            printBetweenK1K2(root.right, k1,k2);

        }
    }
    public static void main(String[] args) {
       TreeNode root = new TreeNode(10);
       BinaryTree bt = new BinaryTree();
       bt.insert(root,8);
       bt.insert(root,9);
       bt.insert(root,12);
     //  bt.insert(root,11);
       bt.insert(root,16);
       bt.insert(root,4);
       bt.insert(root,6);
       bt.insert(root,3);
       bt.insert(root,5);

       //Should be 57
        bt.inOrder(root);
        System.out.println();
        System.out.println(MaxPathSum.maxPathSum(root));
      //  TopView.topView(root);
       // new InvertBinaryTree().invertTree(root);
       // bt.inOrder(root);
       //LeafNodes nodes = new LeafNodes();
       // System.out.println("Leaf Nodes for the current tree are:"+nodes.findLeaves(root));
     /*   System.out.println(new RightSideView().rightSideView(root));
        System.out.println(ClosestvalBinarySearchTree.findClosestvalInBst(root,15));
        System.out.println(new SymmetricalTree().symmetricalTree(root));
        System.out.println(closestBinarySearchTreeval.closestval(root,3));
        ValidateThreeNodes threeNodes = new ValidateThreeNodes();
        System.out.println(threeNodes.validateThreeNodes(root,node1,node2));
        System.out.println(IsHeightBalanced.heightBalancedBinaryTree(root));


      
<<<<<<< HEAD
=======
        KthSmallestval kthSmallestval = new KthSmallestval();
        System.out.println(kthSmallestval.kthSmallest(root,8));
>>>>>>> f6eae002925c5b719372e404bff6bf5619d8b3cf
       
        System.out.println(output);

        System.out.println(MaxPathSum.maxPathSum(root));
>>>>>>> f6eae002925c5b719372e404bff6bf5619d8b3cf
		*/
               NodesAtDistanceKDFS nodes1 = new NodesAtDistanceKDFS();
        System.out.println(nodes1.findNodesDistanceK(root,root.left,2));
                System.out.println("Hi");
               // System.out.println(nodes1.findNodesDistanceK(root,9,3));
        //TreeNode right = root.right.left;
     //   System.out.println("Inorder Successor of: " + right.val);
       // System.out.println(new InOrderSuccessor().inorderSuccessor(root,right).val);
       BinaryTreePaths paths = new BinaryTreePaths();
        System.out.println(paths.binaryTreePaths(root));
        MaxDifferenceNodeAncestor differenceNodeAncestor = new MaxDifferenceNodeAncestor();
        System.out.println(differenceNodeAncestor.maxAncestorDiff(root));

        printBetweenK1K2(root,4,10);
        System.out.println();
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println(sumRootToLeaf.sumNumbers(root));
    }
}
