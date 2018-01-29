/* This application is about courses. A course has a course code,
 * a title, a fee and a number of sessions. A session specifies
 * a date, a starting hour and ending hour. You have also created the
 * following classes:
 */
class Course {
    String courseId;
    String title;
    int fee;
    Session sessions[];
}
class Session {
    Date date;
    int startHour;
    int endHour;
}
/* The DBA (database administator) has created the tables below:
create table Courses ( courseId varchar(20) primary key,
    title varchar(20) not null, fee int not null);
create table Sessions ( courseId varchar(20), sessionId int,
    sessionDate date not null,startHour int not null,
    endHour int not null,primary key(courseId, sessionId)
);
Your tasks are:
1. Create an interface for accessing the courses while hiding the database.
2. Create a class to implement that interface and show how to implement
   its method for adding a course to the database.
3. Give outline of its method for enumerating all courses whose total duration
   is greater than a specified number of hours.
*/