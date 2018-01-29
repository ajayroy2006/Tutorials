/* This is a web-based application concerned with training courses. 
 * A user can choose a subject area 
 * 		("IT", "Management", "Language", "Apparel") 
 * in a form and click submit. Then the application will display all 
 * the courses in that subject area. The servlet doing that is shown below.
 */
public class ShowCoursesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><TITLE>Course listing</TITLE><BODY>");
        Connection dbConn = ...;
        PreparedStatement st =
            dbConn.prepareStatement("select * from Courses where subjArea=?");
        try {
            st.setString(1, request.getParameter("SubjArea"));
            ResultSet rs = st.executeQuery();
            try {
                out.println("<TABLE>");
                while (rs.next()) {
                    out.println("<TR>");
                    out.println("<TD>");
                    out.println(rs.getString(1)); //course code
                    out.println("</TD>");
                    out.println("<TD>");
                    out.println(rs.getString(2)); //course name
                    out.println("</TD>");
                    out.println("<TD>");
                    out.println(""+rs.getInt(3)); //course fee in MOP
                    out.println("</TD>");
                    out.println("</TR>");
                }
                out.println("</TABLE>");
            } finally {
                rs.close();
            }
        } finally {
            st.close();
        } 
        out.println("</BODY></HTML>");
    }
}
/*Your tasks are:
 * 1. Point out and remove the problems in the code.
 * 2. Divide your revised code into appropriate layers.
*/