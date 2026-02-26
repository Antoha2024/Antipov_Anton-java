package collections.hashmap;

import java.util.*;

public class CustomHashMap<K, V> implements Map<K, V> {
    private Map<K, V> internalMap;
    
    public CustomHashMap() {
        this.internalMap = new HashMap<>();
    }
    
    public CustomHashMap(Map<K, V> map) {
        this.internalMap = map;
    }
    
    public void setImplementation(Map<K, V> newMap) {
        newMap.putAll(this.internalMap);
        this.internalMap = newMap;
    }
    
    public Class<?> getImplementationType() {
        return internalMap.getClass();
    }
    
    @Override
    public V put(K key, V value) {
        return internalMap.put(key, value);
    }
    
    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }
    
    @Override
    public V remove(Object key) {
        return internalMap.remove(key);
    }
    
    @Override
    public int size() {
        return internalMap.size();
    }
    
    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }
    
    @Override
    public boolean containsKey(Object key) {
        return internalMap.containsKey(key);
    }
    
    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }
    
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        internalMap.putAll(m);
    }
    
    @Override
    public void clear() {
        internalMap.clear();
    }
    
    @Override
    public Set<K> keySet() {
        return internalMap.keySet();
    }
    
    @Override
    public Collection<V> values() {
        return internalMap.values();
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }
    
    @Override
    public String toString() {
        return internalMap.toString();
    }
}