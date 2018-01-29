/* Suppose that in general a teacher can teach many students. However, 
 * a graduate student can be taught by a graduate teacher only. 
 * Point out and remove the problem in the code:
 */

class Student {
    String studentId;
    ...
}
class Teacher {
    String teacherId;
    Vector studentsTaught;
	//...
    public String getId() {
        return teacherId;
    }
    public void addStudent(Student student) {
        studentsTaught.add(student);
    }
}
class GraduateStudent extends Student {
...
}
class GraduateTeacher extends Teacher {
...
}
