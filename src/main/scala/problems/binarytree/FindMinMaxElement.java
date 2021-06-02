package problems.binarytree;

public class FindMinMaxElement {
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode().create();
        System.out.println("Maximum value : ");
        findMax(root);
        System.out.println(max);
        System.out.println("Minimum value : ");
        findMin(root);
        System.out.println(min);
    }

    private static void findMax(TreeNode root) {
        if(root == null){
            return ;
        }
        int value = root.value;
        if(value > max){
            max = value;
        }
        findMax(root.left);
        findMax(root.right);
    }

    private static void findMin(TreeNode root) {
        if(root == null){
            return ;
        }
        int value = root.value;
        if(value < min){
            min = value;
        }
        findMin(root.left);
        findMin(root.right);
    }
}
