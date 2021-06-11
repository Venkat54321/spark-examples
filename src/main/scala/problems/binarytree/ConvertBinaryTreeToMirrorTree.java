package problems.binarytree;

public class ConvertBinaryTreeToMirrorTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode().create();
        mirror(root);
    }

    private static void mirror(TreeNode root) {
        createMirrorImage(root);
        System.out.println(root);
    }

    private static void createMirrorImage(TreeNode node) {
        if(node == null){
            return;
        }
        createMirrorImage(node.left);
        createMirrorImage(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
