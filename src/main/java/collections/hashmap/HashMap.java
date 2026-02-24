package collections.hashmap;

import java.util.Arrays;

public class HashMap {
    
    // Параллельные массивы для хранения
    private String[] keys;
    private Object[] values;
    private boolean[] used;  // отметка, используется ли ячейка
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    
    // Конструктор
    public HashMap() {
        keys = new String[DEFAULT_CAPACITY];
        values = new Object[DEFAULT_CAPACITY];
        used = new boolean[DEFAULT_CAPACITY];
        size = 0;
    }
    
    /**
     * Хеш-функция - вычисляет индекс в массиве
     */
    private int hash(String key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % keys.length);
    }
    
    private int findIndex(String key) {
        int index = hash(key);
        int startIndex = index;
        
        // Ищем либо сам ключ, либо пустое место
        while (used[index]) {
            if (key == null && keys[index] == null) {
                return index;  // нашли наш null ключ
            }
            if (key != null && key.equals(keys[index])) {
                return index;  // нашли наш ключ
            }
            
            index = (index + 1) % keys.length;
            
            // Если вернулись в начало - массив полон
            if (index == startIndex) {
                return -1;  // массив полон
            }
        }
        
        return index;  // нашли пустое место
    }
    
    /**
     * Добавляет пару ключ-значение
     * @param key ключ (строка)
     * @param value значение (любой объект)
     * @return предыдущее значение или null
     */
    public Object put(String key, Object value) {
        // Проверяем необходимость расширения
        if (size >= keys.length * 0.75) {
            resize();
        }
        
        int index = findIndex(key);
        
        if (index == -1) {
            // Массив полон - расширяем и пробуем снова
            resize();
            return put(key, value);
        }
        
        if (used[index] && 
            (key == null ? keys[index] == null : key.equals(keys[index]))) {
            // Обновление существующего ключа
            Object oldValue = values[index];
            values[index] = value;
            return oldValue;
        } else {
            // Добавление нового ключа
            keys[index] = key;
            values[index] = value;
            used[index] = true;
            size++;
            return null;
        }
    }
    
    /**
     * Получает значение по ключу
     * @param key ключ
     * @return значение или null
     */
    public Object get(String key) {
        int index = hash(key);
        int startIndex = index;
        
        while (used[index]) {
            if (key == null && keys[index] == null) {
                return values[index];
            }
            if (key != null && key.equals(keys[index])) {
                return values[index];
            }
            
            index = (index + 1) % keys.length;
            if (index == startIndex) {
                break;  // прошли весь массив
            }
        }
        
        return null;
    }
    
    /**
     * Удаляет запись по ключу
     * @param key ключ
     * @return удаленное значение или null
     */
    public Object remove(String key) {
        int index = hash(key);
        int startIndex = index;
        
        while (used[index]) {
            if (key == null && keys[index] == null) {
                Object oldValue = values[index];
                keys[index] = null;
                values[index] = null;
                used[index] = false;
                size--;
                
                // Перехешируем последующие элементы
                rehashFrom(index);
                return oldValue;
            }
            if (key != null && key.equals(keys[index])) {
                Object oldValue = values[index];
                keys[index] = null;
                values[index] = null;
                used[index] = false;
                size--;
                
                // Перехешируем последующие элементы
                rehashFrom(index);
                return oldValue;
            }
            
            index = (index + 1) % keys.length;
            if (index == startIndex) {
                break;
            }
        }
        
        return null;
    }
    
    /**
     * Перехеширование после удаления
     */
    private void rehashFrom(int start) {
        int index = (start + 1) % keys.length;
        
        while (used[index]) {
            String keyToMove = keys[index];
            Object valueToMove = values[index];
            
            // Удаляем временно
            keys[index] = null;
            values[index] = null;
            used[index] = false;
            size--;
            
            // Добавляем заново (найдет правильное место)
            put(keyToMove, valueToMove);
            
            index = (index + 1) % keys.length;
        }
    }
    
    /**
     * Расширение массива
     */
    private void resize() {
        int newCapacity = keys.length * 2;
        String[] oldKeys = keys;
        Object[] oldValues = values;
        boolean[] oldUsed = used;
        
        keys = new String[newCapacity];
        values = new Object[newCapacity];
        used = new boolean[newCapacity];
        size = 0;
        
        // Перехешируем все существующие элементы
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldUsed[i]) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }
    
    /**
     * Возвращает количество элементов
     */
    public int size() {
        return size;
    }
    
    /**
     * Проверяет, пуста ли карта
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Проверяет, содержит ли карта ключ
     */
    public boolean containsKey(String key) {
        return get(key) != null;
    }
    
    /**
     * Очищает карту
     */
    public void clear() {
        Arrays.fill(keys, null);
        Arrays.fill(values, null);
        Arrays.fill(used, false);
        size = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        
        for (int i = 0; i < keys.length; i++) {
            if (used[i]) {
                if (!first) sb.append(", ");
                sb.append(keys[i]).append("=").append(values[i]);
                first = false;
            }
        }
        
        sb.append("}");
        return sb.toString();
    }
}