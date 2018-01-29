interface Courses {
	Course[] getCoursesInSubject(String subjArea);
} 

//Database logic
class CoursesInDB implements Courses {
	Course[] getCoursesInSubject(String subjArea) {
		Connection dbConn = ...;
		PreparedStatement st =
			dbConn.prepareStatement("select * from Courses where subjArea=?");
		try {
			st.setString(1, subjArea);
			ResultSet rs = st.executeQuery();
			try {
				Course courses[];
				while (rs.next()) {
					Course course = new Course(
					rs.getString(1),
					rs.getString(2),
					rs.getInt(3));
					//add course to courses;
				}
				return courses;
			} finally {
				rs.close();
			}
		} finally {
			st.close();
		}
	}
}

//UI logic
public class ShowCoursesServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><TITLE>Course listing</TITLE><BODY>");
		Courses courses =
			(Courses)getServletContext().getAttribute("Courses");
		Course coursesInSubject[] =
		courses.getCoursesInSubject(request.getParameter("SubjArea"));
		out.println("<TABLE>");
		for (int i = 0; i < coursesInSubject.length; i++) {
				Course course = coursesInSubject[i];
				out.println("<TR>");
				out.println("<TD>");
				out.println(course.getCourseCode());
				out.println("</TD>");
				out.println("<TD>");
				out.println(course.getCourseName());
				out.println("</TD>");
				out.println("<TD>");
				out.println(course.getCourseFeeInMOP());
				out.println("</TD>");
				out.println("</TR>");
		}
		out.println("</TABLE>");
		out.println("</BODY></HTML>");
	}
}
