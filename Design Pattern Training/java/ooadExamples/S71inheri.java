//Hashmap has a function put. We don't need that in CourseCatalog
public class CourseCatalog {
    HashMap map;
    public void addCourse(Course c) {
        map.put(c.getTitle(), c);
    }
    public Course findCourse(String title) {
        return (Course)map.get(title);
    }
    public int countCourses() {
        return map.size();
    }
}
