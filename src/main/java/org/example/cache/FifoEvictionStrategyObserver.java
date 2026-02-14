package org.example.cache;

import org.example.cache.interfaces.CacheEvictionStrategy;
import org.example.cache.interfaces.CacheObserver;

import java.util.LinkedList;
import java.util.Queue;

public class FifoEvictionStrategyObserver<K> implements CacheObserver<K>, CacheEvictionStrategy<K> {
    private Queue<K> fifoQueue = new LinkedList<>();
    @Override
    public K evict() {
        return fifoQueue.peek();
    }

    @Override
    public void notifyOnCreate(K key) {
        fifoQueue.add(key);
    }

    @Override
    public void notifyOnGet(K key) {}

    @Override
    public void notifyOnDelete(K key) {
        fifoQueue.remove(key);
    }
}
