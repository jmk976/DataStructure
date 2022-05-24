package Sec10_Tree;

public class lc104_Maximum_Depth_of_Binary_Tree {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x){
            val = x;
        }
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        } else{
            int left_h = maxDepth(root.left);
            int right_h = maxDepth(root.right);

            return 1+ Math.max(left_h, right_h);
        }
    }

    /*
    
    public static void main(String[] args) {
     int[] root=[3,9,20,null,null,15,7];
     TreeNode(3);

    }

    */


    
}
