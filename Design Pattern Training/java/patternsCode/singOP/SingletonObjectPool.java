import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

class Reusable {
	final int value;
	public Reusable(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Reusable [value=" + value + "]";
	}
}
class ReusablePool {
	static ReusablePool instance = new ReusablePool();
	static final int COUNT = 10;
	ArrayBlockingQueue<Reusable> pool = new ArrayBlockingQueue<>(COUNT);
	private ReusablePool() {
		for (int i=1; i<=COUNT; ++i)
			try {
				pool.put(new Reusable(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public static ReusablePool getInstance() {
		return instance;
	}
	public Reusable acquire() {
		try {
			return pool.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void release (Reusable r) {
		try {
			pool.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SingletonObjectPool {
	public static void main(String[] args) {
		for (int i=0; i<50; ++i) 
			new Thread(() -> run()).start();
	}
	private static void run() {
		while (true) {
			waitRandomTime();
			Reusable r = ReusablePool.getInstance().acquire();
			System.out.printf("Thread %d Acquired %s%n", 
					Thread.currentThread().getId() ,r);
			waitRandomTime();
			System.out.printf("Thread %d Releasing %s%n", 
					Thread.currentThread().getId() ,r);
			ReusablePool.getInstance().release(r);
		}
	}
	private static void waitRandomTime() {
		int milliSeconds = ThreadLocalRandom.current().nextInt(7000);
		try {
			Thread.sleep(milliSeconds + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
