import java.util.LinkedList;
import java.util.List;

interface DiskObject {
	int getSize();
}

class File implements DiskObject {
	private final String name;
	private final int size;
	public File(final String name, final int size) {
		this.name = name;
		this.size = size;
	}
	public int getSize() {
		return size;
	}
}

class Directory implements DiskObject {
	List<DiskObject> children = new LinkedList<DiskObject>();
	public int getSize() {
		int sum = 0;
		for (DiskObject o : children)
			sum += o.getSize();
		return sum;
	}
}

public class Composite {
	private static void printSize(final DiskObject d) {
		System.out.printf("The size is %d%n", d.getSize());
	}
	public static void main(final String[] args) {
		Directory d1 = new Directory();
		d1.children.add(new File("f1", 50));
		d1.children.add(new File("f2", 30));
		Directory d2 = new Directory();
		d2.children.add(new File("f1", 100));
		d2.children.add(d1);
		printSize(d2);
	}
}
