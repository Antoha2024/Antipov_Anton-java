package collections.hashmap;

import java.util.*;

public class HashMapTest {
    
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CUSTOM HASHMAP ===\n");
        System.out.println("   java -cp src/main/java collections.hashmap.HashMapTest\n");
        
        // 1. ТЕСТ БАЗОВЫХ ОПЕРАЦИЙ
        System.out.println("1. Базовые операции CustomHashMap:");
        CustomHashMap<String, String> map = new CustomHashMap<>();
        
        map.put("name", "Иван");
        map.put("age", "25");
        map.put("city", "Москва");
        System.out.println("   После put: " + map);
        
        map.put("age", "26");
        System.out.println("   После update: " + map);
        
        map.remove("city");
        System.out.println("   После remove: " + map);
        System.out.println();
        
        // 2. CustomHashMap С РАЗНЫМИ ТИПАМИ ЗНАЧЕНИЙ
        System.out.println("2. CustomHashMap с разными типами значений:");
        
        CustomHashMap<String, Object> objectMap = new CustomHashMap<>();
        objectMap.put("text", "Hello World");
        objectMap.put("number", 42);
        objectMap.put("pi", 3.14159);
        objectMap.put("flag", true);
        
        System.out.println("   objectMap: " + objectMap);
        System.out.println("   Типы значений:");
        System.out.println("      text   -> " + objectMap.get("text").getClass().getSimpleName() + ": " + objectMap.get("text"));
        System.out.println("      number -> " + objectMap.get("number").getClass().getSimpleName() + ": " + objectMap.get("number"));
        System.out.println("      pi     -> " + objectMap.get("pi").getClass().getSimpleName() + ": " + objectMap.get("pi"));
        System.out.println("      flag   -> " + objectMap.get("flag").getClass().getSimpleName() + ": " + objectMap.get("flag"));
        System.out.println();
        
        // 3. ДЕМОНСТРАЦИЯ: LIST МОЖЕТ ХРАНИТЬ РАЗНЫЕ ТИПЫ
        System.out.println("3. ArrayList может хранить разные типы объектов:");
        
        ArrayList<Object> mixedList = new ArrayList<>();
        mixedList.add("Строка");                 // String
        mixedList.add(100);                      // Integer
        mixedList.add(3.14159);                  // Double
        mixedList.add(false);                     // Boolean
        mixedList.add(new int[]{5, 6, 7});        // int[]
        mixedList.add(Arrays.asList("X", "Y", "Z")); // List
        
        System.out.println("   mixedList: " + mixedList);
        System.out.println("   Элементы списка с типами:");
        for (int i = 0; i < mixedList.size(); i++) {
            Object obj = mixedList.get(i);
            System.out.printf("      [%d] %s -> %s%n", 
                i, obj.getClass().getSimpleName(), obj);
            
            // Для массива показываем содержимое
            if (obj instanceof int[]) {
                System.out.printf("          содержимое: %s%n", 
                    Arrays.toString((int[])obj));
            }
            // Для списка показываем содержимое
            if (obj instanceof List) {
                System.out.printf("          содержимое: %s%n", obj);
            }
        }
        System.out.println();
        
        // 4. ДЕМОНСТРАЦИЯ: LINKEDLIST (для сравнения)
        System.out.println("4. LinkedList тоже хранит разные типы:");
        
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("Текст");
        linkedList.add(42);
        linkedList.add(2.71828);
        linkedList.add(true);
        linkedList.add(new String[]{"один", "два"});
        
        System.out.println("   linkedList: " + linkedList);
        System.out.println("   Элементы LinkedList:");
        for (int i = 0; i < linkedList.size(); i++) {
            Object obj = linkedList.get(i);
            System.out.printf("      [%d] %s -> %s%n", 
                i, obj.getClass().getSimpleName(), obj);
            
            if (obj instanceof String[]) {
                System.out.printf("          массив: %s%n", 
                    Arrays.toString((String[])obj));
            }
        }
        System.out.println();
        
        // 5. СМЕНА РЕАЛИЗАЦИИ
        System.out.println("5. Смена реализации:");
        
        CustomHashMap<String, String> customMap = new CustomHashMap<>();
        customMap.put("banana", "2");
        customMap.put("apple", "1");
        customMap.put("cherry", "3");
        
        System.out.println("   HashMap (случайный порядок): " + customMap);
        System.out.println("   Тип: " + customMap.getImplementationType().getSimpleName());
        
        customMap.setImplementation(new TreeMap<>());
        System.out.println("   TreeMap (отсортировано): " + customMap);
        System.out.println("   Тип: " + customMap.getImplementationType().getSimpleName());
        
        System.out.println("\n=== ИТОГ ===");
        System.out.println("✅ CustomHashMap: базовые операции");
        System.out.println("✅ CustomHashMap: разные типы значений");
        System.out.println("✅ ArrayList: разные типы элементов");
        System.out.println("✅ LinkedList: тоже поддерживает разные типы");
        System.out.println("✅ CustomHashMap: смена реализации");
    }
}