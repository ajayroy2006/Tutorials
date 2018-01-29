package springAspectDemo;


public class SimpleCache implements Cache {
	private int cacheSize;
	@TrackChanges
	@Override 
	public void setCacheSize(int size) {
		cacheSize = size;
	}
	public int getCacheSize() {
		return cacheSize;
	}
	//Other methods as needed
}
