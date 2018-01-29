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

interface Courses {
	void addCourse(Course course);
	void deleteCourse(String courseId);
	void updateCourse(Course course);
	Course[] getAllCoursesById();
	Course[] getCoursesLongerThan(int duration);
}
class CoursesInDB implements Courses {
	void addCourse(Course course) {
		PreparedStatement st =
			dbConn.prepareStatement("insert into from Courses values(?,?,?)");
		try {
			st.setString(1, course.getId());
			st.setString(2, course.getTitle());
			st.setInt(3, course.getFee());
			st.executeUpdate();
		} finally {
			st.close();
		}
		st = dbConn.prepareStatement(
			"insert into from Sessions values(?,?,?,?,?)");
		try {
			for (int i = 0; i < course.getNoSessions(); i++) {
				Session session = course.getSessionAt(i);
				st.setString(1, course.getId());
				st.setInt(2, i);
				st.setDate(3, session.getDate());
				st.setInt(4, session.getStartHour());
				st.setInt(5, session.getEndHour());
				st.executeUpdate();
			}
		} finally {
			st.close();
		}
	}
	Course[] getCoursesLongerThan(int duration) {
		...
	}
}
