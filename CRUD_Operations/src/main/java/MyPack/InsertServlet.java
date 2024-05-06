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

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		
			int RollNo=Integer.parseInt(request.getParameter("rollno"));
			String Name=request.getParameter("name");
			int Java=Integer.parseInt(request.getParameter("java"));
			int SL=Integer.parseInt(request.getParameter("sl"));
			int LS=Integer.parseInt(request.getParameter("ls"));
			float perc=(Java+SL+LS)/3;
		Connection conn=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		conn=DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
		
		System.out.println("InsertData Connected");
		
		//String query="insert into crudstu (rollno,name,java,sl,ls) values(?,?,?,?,?)";
		String query="insert into crudstu values(?,?,?,?,?,?)";
		PreparedStatement pd=conn.prepareStatement(query);
		pd.setInt(1, RollNo);
		pd.setString(2, Name);
		pd.setInt(3, Java);
		pd.setInt(4, SL);
		pd.setInt(5, LS);
		pd.setFloat(6, perc);
		int affected=pd.executeUpdate();
		if(affected>0)
		{
			System.out.println("Data Inserted");
		}
		else
		{
			System.out.println("Null");
		}
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
