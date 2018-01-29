import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
/* We want to cache immutable objects.
   Create a LRU cache for immutable objects
   Hint: Use removeEldestEntry function in LinkedHashMap
*/
class LruCache<E> {
	private final int maxEntries;
	private final Map<E, E> cache = new LruCacheMap<E, E>();

	public LruCache(int capacity) {
		maxEntries = capacity;
	}

	class LruCacheMap<A, B> extends LinkedHashMap<A, B> {
		public LruCacheMap() {
			super(maxEntries + 1, 1.1f, true);
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<A, B> eldest) {
			return super.size() > maxEntries;
		}
	}

	public synchronized E addIfNotPresentAndReturnFromCache(E object) {
		if (cache.containsKey(object))
			return cache.get(object);
		cache.put(object, object);
		return object;
	}

	@Override
	public String toString() {
		return "Cache contains " + cache;
	}
}

public class FlyweightCache {
	public static void main(String[] args) {
		LruCache<LocalDate> myDateCache = new LruCache<>(5);
		for (int i = 1; i <= 30; ++i)
			myDateCache.addIfNotPresentAndReturnFromCache(LocalDate.of(2015, 1,	i));
		System.out.println(myDateCache);
		LocalDate a = LocalDate.of(2015, 2, 1);
		LocalDate b = LocalDate.of(2015, 2, 1);
		System.out.printf("Two different date objects created for the same date? %b%n",	(a != b));
		a = myDateCache.addIfNotPresentAndReturnFromCache(a);
		b = myDateCache.addIfNotPresentAndReturnFromCache(b);
		System.out.printf("Second date replaced with existing item from cache? %b%n", (a == b));
	}
}
