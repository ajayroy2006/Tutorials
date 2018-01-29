//Remove the problem in code below.
//Assume that PropertyFileWriter is not used anywhere else
//other than class App.
class PropertyFileWriter extends FileWriter {
    PropertyFileWriter(String path) {
        super(new File(path));
    }
    void writeEntry(String key, String value) {
        super.write(key+"="+value);
    }
	//Many more functions here
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
