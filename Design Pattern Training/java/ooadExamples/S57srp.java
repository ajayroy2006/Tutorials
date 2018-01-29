class Student {
    String studentId;
    String name;
    Date dateOfBirth;
}
class Enrollment {
    String studentId;
    String courseCode;
    Date enrollDate;
    Payment payment;
}
class Enrollments {
    Enrollment enrollments[];
    void enroll(String studentId, String courseCode, Date enrollDate,
            Payment payment) {
        Enrollment enrollment = new Enrollment(studentId, courseCode, ...);
        //add enrollment to enrollments;
    }
    void unenroll(String studentId, String courseCode) {
        ...
    }
}
class StudentManagementSystem {
    Student students[];
    Enrollments enrollments;
}
