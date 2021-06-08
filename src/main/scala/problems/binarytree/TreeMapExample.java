package problems.binarytree;

import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(5,3);
        treeMap.put(8,4);
        treeMap.put(1,5);
        System.out.println(treeMap);
    }
}
