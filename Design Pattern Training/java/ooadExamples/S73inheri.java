abstract class Student {
    String studentId;
    ...
}
class NonGraduateStudent extends Student {
}
class GraduateStudent extends Student {
}
abstract class Teacher {
    String teacherId;
    List studentsTaught;
	//...
    public String getId() {
        return teacherId;
    }
}
class NonGraduateTeacher extends Teacher {
    public void addStudent(NonGraduateStudent student) {
        studentsTaught.add(student);
    }
}
class GraduateTeacher extends Teacher {
    public void addStudent(Student student) {
        studentsTaught.add(student);
    }
}
