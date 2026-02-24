package collections.hashmap;

import java.util.Arrays;

/**
 * Тестовый класс для HashMap
 */
public class HashMapTest {
    
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ HASHMAP ===\n");
        
        // Создаем карту
        HashMap map = new HashMap();
        
        // ТЕСТ 1: put (добавление)
        System.out.println("1. PUT (добавление):");
        System.out.println("   put('name', 'Иван') -> " + map.put("name", "Иван"));
        System.out.println("   put('age', 25) -> " + map.put("age", 25));
        System.out.println("   put('city', 'Москва') -> " + map.put("city", "Москва"));
        System.out.println("   Карта: " + map);
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // ТЕСТ 2: get (получение)
        System.out.println("2. GET (получение):");
        System.out.println("   get('name'): " + map.get("name"));
        System.out.println("   get('age'): " + map.get("age"));
        System.out.println("   get('city'): " + map.get("city"));
        System.out.println("   get('xxx'): " + map.get("xxx"));
        System.out.println();
        
        // ТЕСТ 3: put (обновление)
        System.out.println("3. PUT (обновление):");
        Object old = map.put("age", 26);
        System.out.println("   put('age', 26) вернул: " + old);
        System.out.println("   get('age') после обновления: " + map.get("age"));
        System.out.println("   Карта: " + map);
        System.out.println();
        
        // ТЕСТ 4: remove (удаление)
        System.out.println("4. REMOVE (удаление):");
        Object removed = map.remove("city");
        System.out.println("   remove('city') вернул: " + removed);
        System.out.println("   Карта после удаления: " + map);
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // ТЕСТ 5: null ключи
        System.out.println("5. NULL ключи:");
        map.put(null, "NULL_VALUE");
        System.out.println("   put(null, 'NULL_VALUE')");
        System.out.println("   Карта: " + map);
        System.out.println("   get(null): " + map.get(null));
        System.out.println("   containsKey(null): " + map.containsKey(null));
        System.out.println();
        
        // ТЕСТ 6: разные типы значений
        System.out.println("6. РАЗНЫЕ ТИПЫ ЗНАЧЕНИЙ:");
        map.put("number", 123);
        map.put("pi", 3.14159);
        map.put("bool", true);
        map.put("array", new int[]{1, 2, 3, 4, 5});
        
        System.out.println("   Карта: " + map);
        System.out.println("   get('number'): " + map.get("number"));
        System.out.println("   get('pi'): " + map.get("pi"));
        System.out.println("   get('bool'): " + map.get("bool"));
        System.out.println("   get('array'): " + Arrays.toString((int[])map.get("array")));
        System.out.println();
        
        // ТЕСТ 7: containsKey
        System.out.println("7. containsKey:");
        System.out.println("   containsKey('name'): " + map.containsKey("name"));
        System.out.println("   containsKey('city'): " + map.containsKey("city"));
        System.out.println("   containsKey(null): " + map.containsKey(null));
        System.out.println();
        
        // ТЕСТ 8: много элементов (проверка расширения)
        System.out.println("8. МНОГО ЭЛЕМЕНТОВ:");
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "value" + i);
        }
        System.out.println("   Добавлено 20 элементов");
        System.out.println("   get('key5'): " + map.get("key5"));
        System.out.println("   get('key15'): " + map.get("key15"));
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // ТЕСТ 9: clear
        System.out.println("9. CLEAR:");
        map.clear();
        System.out.println("   После clear: " + map);
        System.out.println("   isEmpty: " + map.isEmpty());
        System.out.println("   Размер: " + map.size());
        
        System.out.println("\n=== ВСЕ ТЕСТЫ ПРОЙДЕНЫ ===");
    }
}