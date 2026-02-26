package collections.hashmap;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

public class HashMap<K, V> implements Map<K, V> {
    
    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
        
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V newValue) { V old = value; value = newValue; return old; }
        public String toString() { return key + "=" + value; }
    }
    
    private Node<K, V>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    public HashMap() {
        table = (Node<K, V>[]) new Node<?, ?>[INITIAL_CAPACITY];
    }
    
    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() % table.length;
    }
    
    @Override
    public V put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = table[index];
        
        if (node == null) {
            table[index] = new Node<>(hash(key), key, value, null);
            size++;
            return null;
        }
        
        while (true) {
            if (node.hash == hash(key) && 
                (node.key == key || (key != null && key.equals(node.key)))) {
                V old = node.value;
                node.value = value;
                return old;
            }
            if (node.next == null) break;
            node = node.next;
        }
        
        node.next = new Node<>(hash(key), key, value, null);
        size++;
        return null;
    }
    
    @Override
    public V get(Object key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        
        while (node != null) {
            if (node.hash == hash(key) && 
                (node.key == key || (key != null && key.equals(node.key)))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    
    @Override
    public V remove(Object key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        
        if (node == null) return null;
        
        if (node.hash == hash(key) && 
            (node.key == key || (key != null && key.equals(node.key)))) {
            table[index] = node.next;
            size--;
            return node.value;
        }
        
        Node<K, V> prev = node;
        node = node.next;
        while (node != null) {
            if (node.hash == hash(key) && 
                (node.key == key || (key != null && key.equals(node.key)))) {
                prev.next = node.next;
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
    
    @Override
    public int size() { return size; }
    
    @Override
    public boolean isEmpty() { return size == 0; }
    
    @Override
    public boolean containsKey(Object key) { return get(key) != null; }
    
    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) table[i] = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Node<K, V> node : table) {
            while (node != null) {
                if (!first) sb.append(", ");
                sb.append(node.key).append("=").append(node.value);
                first = false;
                node = node.next;
            }
        }
        return sb.append("}").toString();
    }
    
    // Заглушки для остальных методов интерфейса Map
    public boolean containsValue(Object value) { return false; }
    public void putAll(Map<? extends K, ? extends V> m) { }
    public Set<K> keySet() { return null; }
    public Collection<V> values() { return null; }
    public Set<Map.Entry<K, V>> entrySet() { return null; }
}