package org.example.cache.interfaces;

public interface CacheEvictionStrategy<K> {
    public K evict();
}
