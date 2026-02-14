package org.example.cache.interfaces;

public interface CacheObserver<K> {
    public void notifyOnCreate(K key);
    public void notifyOnGet(K key);
    public void notifyOnDelete(K key);
}
