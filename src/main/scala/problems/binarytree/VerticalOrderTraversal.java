package problems.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode().createBST();

        int h = 0;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        getVerticalOrder(root,map,h);

        for(Map.Entry<Integer, ArrayList<Integer>> map1: map.entrySet()){
            System.out.println(map1.getValue());
        }

    }

    private static void getVerticalOrder(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map, int h) {
        if(root == null){
            return;
        }
        if(map.get(h) == null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.value);
            map.put(h,list);
        }else{
            ArrayList<Integer> list = map.get(h);
            list.add(root.value);
            map.put(h,list);
        }
        getVerticalOrder(root.left,map,h-1);
        getVerticalOrder(root.right,map,h+1);
    }
}
