package MyPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			Connection conn=null;
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
			
			System.out.println("Select Done");
			
			String query="select *from crudstu";
			PreparedStatement pd=conn.prepareStatement(query);
			ResultSet rs=pd.executeQuery();
			
			ArrayList<Student>arrystu=new ArrayList<Student>();
			while(rs.next())
			{
				Student stu=new Student();
				stu.rollno=rs.getInt("rollno");
				stu.name=rs.getString("name");
				stu.java=rs.getInt("java");
				stu.sl=rs.getInt("sl");
				stu.ls=rs.getInt("ls");
				stu.perc=rs.getFloat("percentage");
				arrystu.add(stu);
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("data", arrystu);
			response.sendRedirect("Display.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Select Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
