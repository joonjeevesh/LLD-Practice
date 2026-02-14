package org.example.cache;

import org.example.cache.interfaces.CacheObserver;

import java.util.ArrayList;
import java.util.List;

public class CacheObservable<K> {
    private List<CacheObserver<K>> subsribers = new ArrayList<>();

    public void subscribe(CacheObserver<K> observer) {
        subsribers.add(observer);
    }

    public void unsubscribe(CacheObserver<K> observer) {
        subsribers.remove(observer);
    }

    public void notifyAllOnCreate(K key) {
        for (CacheObserver<K> subscriber: subsribers) {
            subscriber.notifyOnCreate(key);
        }
    }

    public void notifyAllOnGet(K key) {
        for (CacheObserver<K> subscriber: subsribers) {
            subscriber.notifyOnGet(key);
        }
    }

    public void notifyAllOnDelete(K key) {
        for (CacheObserver<K> subscriber: subsribers) {
            subscriber.notifyOnDelete(key);
        }
    }
}
