package collections.hashmap;

public class HashMapTest {
    
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ HASHMAP ===\n");
        
        HashMap<String, String> map = new HashMap<>();
        
        // Тест 1: добавление
        System.out.println("1. Добавление:");
        map.put("name", "Иван");
        map.put("age", "25");
        map.put("city", "Москва");
        System.out.println("   Карта: " + map);
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // Тест 2: получение
        System.out.println("2. Получение:");
        System.out.println("   name: " + map.get("name"));
        System.out.println("   age: " + map.get("age"));
        System.out.println("   city: " + map.get("city"));
        System.out.println("   xxx: " + map.get("xxx"));
        System.out.println();
        
        // Тест 3: обновление
        System.out.println("3. Обновление:");
        String old = map.put("age", "26");
        System.out.println("   put('age', '26') вернул: " + old);
        System.out.println("   age теперь: " + map.get("age"));
        System.out.println();
        
        // Тест 4: удаление
        System.out.println("4. Удаление:");
        String removed = map.remove("city");
        System.out.println("   remove('city') вернул: " + removed);
        System.out.println("   Карта: " + map);
        System.out.println();
        
        // Тест 5: null ключ
        System.out.println("5. Null ключ:");
        map.put(null, "NULL_VALUE");
        System.out.println("   get(null): " + map.get(null));
        System.out.println("   containsKey(null): " + map.containsKey(null));
        System.out.println();
        
        // Тест 6: много элементов
        System.out.println("6. Много элементов:");
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, "value" + i);
        }
        System.out.println("   get(key5): " + map.get("key5"));
        System.out.println("   Размер: " + map.size());
        System.out.println();
        
        // Тест 7: очистка
        System.out.println("7. Очистка:");
        map.clear();
        System.out.println("   После clear: " + map);
        System.out.println("   isEmpty: " + map.isEmpty());
        
        System.out.println("\n=== ТЕСТЫ ЗАВЕРШЕНЫ ===");
    }
}