package org.example.cache;

import org.example.cache.interfaces.Cache;
import org.example.cache.interfaces.CacheEvictionStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<KEY, VALUE> implements Cache<KEY, VALUE> {

    private int capacity;

    private int ttl;

    private Map<KEY, VALUE> cacheValues = new ConcurrentHashMap<>();

    private CacheEvictionStrategy<KEY> cacheEvictionStrategy;

    private CacheObservable<KEY> cacheObservable;

    public InMemoryCache(int capacity, int ttl, CacheEvictionStrategy<KEY> cacheEvictionStrategy, CacheObservable<KEY> cacheObservable) {
        this.capacity = capacity;
        this.ttl = ttl;
        this.cacheEvictionStrategy = cacheEvictionStrategy;
        this.cacheObservable = cacheObservable;
    }

    private boolean isCacheFull() {
        return this.cacheValues.size() >= capacity;
    }

    @Override
    public void insert(KEY key, VALUE value) {
        if(cacheValues.containsKey(key)) {
            throw new RuntimeException("Cache already contains key, use update");
        }

        if(isCacheFull()) {
            KEY keyToDelete = cacheEvictionStrategy.evict();
            this.delete(keyToDelete);
        }

        cacheValues.put(key, value);
        cacheObservable.notifyAllOnCreate(key);
    }

    @Override
    public VALUE get(KEY key) {
        cacheObservable.notifyAllOnGet(key);
        return cacheValues.get(key);
    }

    @Override
    public void update(KEY key, VALUE value) {
        if(!cacheValues.containsKey(key)) {
            throw new RuntimeException("Cache does not contains key, use insert");
        }

        cacheValues.put(key, value);
    }

    @Override
    public void delete(KEY key) {
        cacheValues.remove(key);
        cacheObservable.notifyAllOnDelete(key);
    }
}
