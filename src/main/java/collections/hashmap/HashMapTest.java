package collections.hashmap;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        
        map.put("name", "Иван");
        map.put("age", "25");
        map.put("city", "Москва");
        System.out.println("После put: " + map);
        
        System.out.println("get(name): " + map.get("name"));
        System.out.println("get(age): " + map.get("age"));
        
        map.put("age", "26");
        System.out.println("После update: " + map);
        
        map.remove("city");
        System.out.println("После remove: " + map);
        
        map.setImplementation(new TreeMap<>());
        System.out.println("После смены на TreeMap: " + map);
    }
}