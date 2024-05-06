package MyPack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update2Servlet
 */
@WebServlet("/Update2Servlet")
public class Update2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update2Servlet() {
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
			
			HttpSession session=request.getSession();
			int RollNo1=(Integer)session.getAttribute("rollno");
			int RollNo=Integer.parseInt(request.getParameter("rollno"));
			String Name=request.getParameter("name");
			int Java=Integer.parseInt(request.getParameter("java"));
			int SL=Integer.parseInt(request.getParameter("sl"));
			int LS=Integer.parseInt(request.getParameter("ls"));
			
			System.out.println("Update Done");
			
			String query="update crudstu set rollno=?,name=?,java=?,sl=?,ls=? where rollno=?";
			PreparedStatement pd=conn.prepareStatement(query);
			pd.setInt(1, RollNo);
			pd.setString(2, Name);
			pd.setInt(3, Java);
			pd.setInt(4, SL);
			pd.setInt(5, LS);
			pd.setInt(6, RollNo1);
			pd.executeUpdate();
			response.sendRedirect("InsertData.jsp");
		}	
		
		catch(Exception e)
		{
			System.out.println("Error in Insert");
			e.printStackTrace();
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
