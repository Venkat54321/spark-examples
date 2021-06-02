package problems.binarytree;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode().create();
        System.out.println("Pre-order");
        preOrder(root);
       /* System.out.println("");
        System.out.println("In-order");
        inOrder(root);*/
        System.out.println("");
        /*System.out.println("Post-order");
        postOrder(root);*/
        System.out.println("");

    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + "  ");
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + "  ");
        inOrder(root.right);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

