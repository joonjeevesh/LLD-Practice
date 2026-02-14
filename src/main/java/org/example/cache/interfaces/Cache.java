package org.example.cache.interfaces;

public interface Cache<KEY, VALUE> {

    public void insert(KEY key, VALUE value);

    public VALUE get(KEY key);

    public void update(KEY key, VALUE value);

    public void delete(KEY key);
}
