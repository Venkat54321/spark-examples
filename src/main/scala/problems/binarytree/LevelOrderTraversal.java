package problems.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode().create();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            System.out.println("");
            System.out.print(tmp.value + "  ");

            if(tmp.left != null){
                queue.add(tmp.left);
            }

            if(tmp.right != null){
                queue.add(tmp.right);
            }
            
        }
    }
}
