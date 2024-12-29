package com.cleo.algorithms.graphs;

public class LowestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        if(topAncestor==null)
            return null;
        else if(topAncestor==descendantOne||topAncestor==descendantTwo)
            return topAncestor;
        AncestralTree lca1 = getYoungestCommonAncestor(topAncestor,descendantOne,descendantTwo.ancestor);
        AncestralTree  lca2 = getYoungestCommonAncestor(topAncestor,descendantOne.ancestor,descendantTwo);
        if(lca1!=null&&lca2!=null)
            return topAncestor;
        else if(lca1!=null)
            return lca1;
        else
            return lca2;


    }

    public static AncestralTree getYoungestCommonAncestorV2(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo){
        int depthOne=getYoungestDepth(topAncestor,descendantOne);
        int depthTwo=getYoungestDepth(topAncestor,descendantTwo);
        int difference = 0;
        if(depthOne>depthTwo)
            return getAncestor(descendantOne,descendantTwo,depthOne-depthTwo);

        else
            return getAncestor(descendantTwo,descendantOne,depthTwo-depthOne);


    }
    public static AncestralTree getAncestor(AncestralTree lowerdescendant,AncestralTree topDescendant, int diff){
        while(diff>0){
            lowerdescendant=lowerdescendant.ancestor;
            diff--;
        }
        while(lowerdescendant!=topDescendant){
            lowerdescendant=lowerdescendant.ancestor;
            topDescendant=topDescendant.ancestor;
        }
        return lowerdescendant;
    }
    public static int getYoungestDepth(AncestralTree topAncestor,AncestralTree descendant){
        int depth=0;
        while(descendant!=topAncestor){
            depth+=1;
            descendant=descendant.ancestor;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
