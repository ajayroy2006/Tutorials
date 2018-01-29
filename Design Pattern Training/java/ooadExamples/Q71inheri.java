//Point out and remove the problem in code below.
public class CourseCatalog extends HashMap {
    public void addCourse(Course c) {
        put(c.getTitle(), c);
    }
    public Course findCourse(String title) {
        return (Course)get(title);
    }
    public int countCourses() {
        return size();
    }
}
