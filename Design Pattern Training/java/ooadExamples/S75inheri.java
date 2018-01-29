//As there is no code that needs to use a PropertyFileWriter as a FileWriter, 
//we should use delegation instead of inheritance:
class PropertyFileWriter {
	FileWriter fileWriter;
	PropertyFileWriter(String path) {
		fileWriter = new FileWriter(new File(path));
	}
	void writeEntry(String key, String value) {
		fileWriter.write(key+"="+value);
	} 
	void close() {
		fileWriter.close();
	}
}
class App {
	void makePropertyFile() {
		PropertyFileWriter fw = new PropertyFileWriter("f1.properties");
		try {
			fw.writeEntry("conference.abc", "10");
			fw.writeEntry("xyz", "hello");
		} finally {
			fw.close();
		}
	}
}