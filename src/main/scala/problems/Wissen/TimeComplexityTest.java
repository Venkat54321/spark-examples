package problems.Wissen;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class TimeComplexityTest {

    public static void main(String[] args) {

        Integer size =0;
        String[] empNames = {"Venkat","alekhya","Rajesh","Rakesh","Anusha"};
        Map<Employee,Integer> map = new HashMap<>();
        for(String name: empNames){
            map.put(new Employee(name),size++);
        }

        System.out.println(map.get(new Employee("Anusha")));


    }
}
