package org.example.cache;

import org.example.cache.interfaces.Cache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryCacheTest {

    private Cache<String, String> cacheToTest;

    @Before
    public void setup() {
        FifoEvictionStrategyObserver<String> fifoObserver = new FifoEvictionStrategyObserver<>();
        CacheObservable<String> cacheObservable = new CacheObservable<>();
        cacheObservable.subscribe(fifoObserver);

        cacheToTest = new InMemoryCache<>(10, 1000, fifoObserver, cacheObservable);
    }

    @Test
    public void cacheCreationSuccess() {
        Assert.assertNotNull("Cache created successfully", cacheToTest);
    }

    @Test
    public void successfulInsertionAndGet() {
        cacheToTest.insert("Test", "TestString");
        Assert.assertEquals("Successful insertion and get", cacheToTest.get("Test"), "TestString");
    }

    @Test
    public void successfulEviction() {
        for(int i=1;i<=11;i++) {
            cacheToTest.insert("Test_" + i, "TestString");
        }

        Assert.assertNull("1st key should be evicted", cacheToTest.get("Test_1"));
    }
}
