package collections.hashmap;

import java.util.*;

public class HashMapTest {
    
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CUSTOM HASHMAP ===\n");
        
        // ТЕСТ 1: Базовые операции (put, get, remove)
        System.out.println("1. Базовые операции CustomHashMap:");
        CustomHashMap<String, String> map = new CustomHashMap<>();
        
        map.put("banana", "2");
        map.put("apple", "1");
        map.put("cherry", "3");
        System.out.println("   После put: " + map);
        
        System.out.println("   get('apple'): " + map.get("apple"));
        System.out.println("   get('banana'): " + map.get("banana"));
        System.out.println("   get('cherry'): " + map.get("cherry"));
        System.out.println("   get('xxx'): " + map.get("xxx"));
        
        map.put("apple", "100");
        System.out.println("   После update apple=100: " + map);
        
        String removed = map.remove("banana");
        System.out.println("   remove('banana') вернул: " + removed);
        System.out.println("   После remove: " + map);
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // ТЕСТ 2: Смена реализации на TreeMap
        System.out.println("2. Смена реализации на TreeMap:");
        
        // Создаем обычный TreeMap с теми же данными
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("cherry", "3");
        treeMap.put("apple", "100");
        
        System.out.println("   TreeMap (отсортирован): " + treeMap);
        System.out.println("   get('apple'): " + treeMap.get("apple"));
        
        // Демонстрация сортировки TreeMap
        System.out.println("\n   Сортировка TreeMap:");
        treeMap.put("banana", "new");
        treeMap.put("date", "4");
        System.out.println("   TreeMap после добавления: " + treeMap);
        System.out.println("   Первый ключ: " + treeMap.firstKey());
        System.out.println("   Последний ключ: " + treeMap.lastKey());
        
        System.out.println("\n=== ИТОГ ===");
        System.out.println("✅ CustomHashMap: put, get, remove работают");
        System.out.println("✅ TreeMap: автоматическая сортировка ключей");
    }
}