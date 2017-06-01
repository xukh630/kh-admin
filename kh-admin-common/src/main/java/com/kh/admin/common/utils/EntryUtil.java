package com.kh.admin.common.utils;

import java.io.Serializable;
import java.util.Map.Entry;

public class EntryUtil {
    private EntryUtil(){
        
    }
    
    /**
     * 创建一个键值对条目。
     * @param key
     * @param value
     * @return
     */
    public static <K,V> Entry<K,V> create(K key, V value) {
        return new SimpleEntry<K,V>(key,value);
    }
    
    private static final class SimpleEntry<K,V> implements Entry<K, V>, Serializable{
        @Override
        public String toString() {
            return "(" + key + " = " + value + ")";
        }

        private static final long serialVersionUID = 4700665734747354709L;
        private V value;
        private K key;
        
        public SimpleEntry(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
           return this.key;
        }

        @Override
        public V getValue() {
          return this.value;
        }

        @Override
        public V setValue(V value) {
           return this.value = value;
        }
        
    }
}
