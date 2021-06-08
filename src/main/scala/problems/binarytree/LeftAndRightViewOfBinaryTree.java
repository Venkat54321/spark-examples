package problems.binarytree;

public class LeftAndRightViewOfBinaryTree {

    private static int left_level_value = Integer.MIN_VALUE;
    private static int right_level_value = Integer.MIN_VALUE;


    public static void main(String[] args) {
        TreeNode root = new TreeNode().createBST();
       // leftView(root,1);
       // System.out.println("Height of tree " + max_value);
        rightView(root,1);
    }

    private static void rightView(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(right_level_value < level){
            System.out.println("  " + root.value);
            right_level_value = level;
        }
        rightView(root.right,level + 1);
        rightView(root.left,level + 1);
    }


    private static void leftView(TreeNode root,int level) {
        if(root == null){
            return;
        }
        if(left_level_value < level){
            System.out.println("  " + root.value);
            left_level_value = level;
        }
        leftView(root.left,level + 1);
        leftView(root.right,level + 1);
    }
}
