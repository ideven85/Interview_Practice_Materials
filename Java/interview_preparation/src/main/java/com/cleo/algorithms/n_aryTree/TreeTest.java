package com.cleo.algorithms.n_aryTree;

import java.util.*;

public class TreeTest{

    static class Pair{
        TreeNode<Integer> root;
        int depth;

        public Pair(TreeNode<Integer> root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    public static TreeNode<Integer> takeInput(){
        Scanner s= new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes= new LinkedList<>();
        System.out.println("Enter the root data ");
        int rootData= s.nextInt();
        if(rootData==-1)
            return null;

        TreeNode<Integer> root= new TreeNode<Integer>(rootData);
        pendingNodes.offer(root);

        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> front= pendingNodes.poll();
            System.out.println("Enter no. of children "+ front.data);
            int numChild= s.nextInt();
            for(int i=0;i<numChild;i++){
                System.out.println("Enter the  "+i+" th child data"+ front.data);
                int childData= s.nextInt();
                TreeNode<Integer> childNode= new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNodes.offer(childNode);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        if(root==null)
            return;
        Queue<List<TreeNode<Integer>>> queue = new LinkedList<>();
        ArrayList<TreeNode<Integer>> s = new ArrayList<>();
        s.add(root);
        queue.offer(s);
        while(!queue.isEmpty()) {
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                List<TreeNode<Integer>> current = queue.poll();
                assert current != null;
                for(TreeNode<Integer> curr:current){
                    System.out.print(curr.data + " ");
                    if(curr.children!=null)
                        queue.offer(curr.children);
                }



            }
            System.out.println();
        }

    }


    public static int numberOfNodes(TreeNode<Integer> root){
        int count =1;
        for(int i=0; i<root.children.size();i++){
            int childCount= numberOfNodes(root.children.get(i));
            count+=childCount;
        }
        return count;
    }

    public static void printTree(TreeNode<Integer> root){
        //Special case not base case
        if(root==null){
            return ;
        }
        System.out.print(root.data+": ");
        for(int i=0; i<root.children.size(); i++){
            System.out.print(root.children.get(i).data+ " ");
        }
        System.out.println();
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> child= root.children.get(i);
            printTree(child);
        }
    }
    public static int getHeight(TreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root==null)
            return 0;


       else{
          Queue<Pair> queue = new LinkedList<>();
          queue.offer(new Pair(root,1));
          int depth=1;
          while(!queue.isEmpty()){
              Pair current=queue.poll();
              TreeNode<Integer> curr = current.root;
              depth=current.depth;
              if(curr.children==null)
                  continue;
              for(TreeNode<Integer> children: curr.children){
                  queue.offer(new Pair(children,depth+1));
              }
          }
            return depth;
        }



    }
    static int sum = Integer.MIN_VALUE;
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        if(root==null)
            return null;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int max_sum=Integer.MIN_VALUE;
        TreeNode<Integer> output = null;
        while(!queue.isEmpty()){
           int sum=0;
            TreeNode<Integer> current = queue.poll();
           sum+=current.data;
           for(TreeNode<Integer> child:current.children){
               sum+= child.data;
               queue.offer(child);
           }
           if(max_sum<=sum) {
               max_sum = sum;
               output=current;
           }
           sum=0;
        }
        return output;


    }
    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here
        if(root==null)
            return;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode<Integer> curr = current.root;
            int depth = current.depth;
            curr.data=depth;
            for(TreeNode<Integer> child: curr.children)
                queue.offer(new Pair(child,depth+1));
        }

    }
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        // Write your code here
        if(root1==null&&root2==null)
            return true;
        else if((root1==null&&root2!=null)||(root1!=null&&root2==null))
            return false;
        else if(root1.data!=root2.data)
            return false;
        else if(root1.children.size()!=root2.children.size())
            return false;
        else {
            for (int i = 0; i < root1.children.size(); i++) {
                TreeNode<Integer> first = root1.children.get(i),second=root2.children.get(i);

                return checkIdentical(first, second);
            }
        }
        return true;
    }
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

        // Write your code here
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        int greater=Integer.MAX_VALUE;
        TreeNode<Integer> answer = null;
        while(!queue.isEmpty()){
            TreeNode<Integer> current = queue.poll();
           // System.out.print(current.data + " ");
            if(current.data>n&&greater> current.data){
                greater=current.data;
                answer=current;
            }
            for(TreeNode<Integer> child: current.children)
                queue.offer(child);
        }
        return answer;

    }

    public static int countLeafNodes(TreeNode<Integer> root){

        // Write your code here
        if(root==null)
            return 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int leafNodes = 0;
        while(!queue.isEmpty()){
            TreeNode<Integer> current = queue.poll();
            if(current.children.isEmpty()){
                leafNodes+=1;
                continue;
            }
            for(TreeNode<Integer> children: current.children)
                queue.offer(children);

        }
        return leafNodes;

    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


        // Write your code here
        if(root==null)
            return null;

        TreeNode<Integer> largest=root,second_largest=root;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int count=1;
        while(!queue.isEmpty()){
            TreeNode<Integer> current = queue.poll();
            if(largest.data<=current.data)
                largest=current;
            if(second_largest.data>=current.data)
                second_largest=current;

            for(TreeNode<Integer> child: current.children) {
                queue.offer(child);
                count++;
            }
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> current = queue.poll();
            if(largest.data!=current.data&&second_largest.data<=current.data)

                second_largest=current;

            for(TreeNode<Integer> child: current.children)
                queue.offer(child);
        }
        if(largest.data==second_largest.data)
            return null;
        return second_largest;


    }
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

        // Write your code here
        if(root==null)
            return false;

       else if(root.data==x)
            return true;
       Queue<TreeNode<Integer>> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           TreeNode<Integer> current = queue.poll();
           if(current.data==x)
               return true;
           for(TreeNode<Integer> child: current.children)
               queue.offer(child);
       }
       return false;
    }

    public static void preOrderTraversal(TreeNode<Integer> root){
        if(root==null)
            return;
        System.out.print(root.data + " ");
        for(TreeNode<Integer> child:root.children)
            preOrderTraversal(child);
    }
    public static void printPostOrder(TreeNode<Integer> root){
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        if(root==null)
            return;
        for(TreeNode<Integer> child: root.children)
            printPostOrder(child);
        System.out.print(root.data+ " ");
    }

    // TODO: 18/08/23  
    public static void inOrder(TreeNode<Integer> root){
        if(root==null)
            return;
        for(TreeNode<Integer> child: root.children){
            System.out.print(child.data+ " ");
            inOrder(child);
            //System.out.println(child.data +" ");
        }
      //  System.out.print(root.data + " ");
    }

    //static int count=0;
    public static int numNodeGreater(TreeNode<Integer> root,int x){

        // Write your code here
        if(root==null)
            return 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int count=0;
        while(!queue.isEmpty()){
            TreeNode<Integer> current = queue.poll();
            if(current.data>x)
                count++;
            for(TreeNode<Integer> children: current.children)
                queue.offer(children);
        }

        return count;

    }
    public static void main(String[] args){
        TreeNode<Integer> root= new TreeNode<> (4);
        TreeNode<Integer>  node1= new TreeNode<> (3);
        TreeNode<Integer> node2 = new TreeNode<>(5);
        TreeNode<Integer> node3 = new TreeNode<>(2);
        node3.children.add(new TreeNode<>(8));
        node1.children.add(node2);
        root.children.add(node3);
        root.children.add(node1);
        printTree(root);
        System.out.println(numberOfNodes(root));
        System.out.println("Height:"+getHeight(root));
        System.out.println("Leaf Nodes"+ countLeafNodes(root));
        System.out.println("Num greater than 1: " + numNodeGreater(root,1));
        System.out.println("Contains: 2" +  checkIfContainsX(root,9));
        System.out.println("Second Largest: " + findSecondLargest(root).data);
        System.out.print("Pre Order:");
        preOrderTraversal(root);
        System.out.print("\nPostOrder Traversal:");
        printPostOrder(root);
        System.out.print("\nInOrder Traversal:");
        inOrder(root);
        System.out.println();
        System.out.println(maxSumNode(root).data);
       // replaceWithDepthValue(root);
        //preOrderTraversal(root);
        System.out.println();
        System.out.println(findNextLargerNode(root,2).data);


    }
}
