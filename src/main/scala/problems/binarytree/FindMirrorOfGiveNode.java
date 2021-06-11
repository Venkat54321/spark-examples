package problems.binarytree;

public class FindMirrorOfGiveNode {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        TreeNode root = new TreeNode().createBST();

        findMirror(root.left,root.right,node);
    }

    private static void findMirror(TreeNode left,TreeNode right, TreeNode node) {
        if(left == null || right == null ){
            return;
        }
        if(left.value == node.value){
            System.out.println("Left Match Mirror value is :" + right.value);
        }
        if(right.value == node.value){
            System.out.println("Right Match Mirror value is :" + left.value);
        }
        findMirror(left.left,right.right,node);
        findMirror(left.right,right.left,node);
    }
}
