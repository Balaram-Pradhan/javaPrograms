/*
 program TO READ DATA FROM TABLE
SelectCMD.java
*/
import java.sql.*;
class SelectCMD
{
	Connection conn=null;
	SelectCMD()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver loaded...");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");
		//System.out.println("connection opened...");

	}
	void readData()throws SQLException
	{
		String sql="select * from student.std_tab";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("stdname")+"\t"+rs.getInt("stdrollno")+"\t"+rs.getString("stddept"));
		}
		rs.close();
		ps.close();
	}
	public static void main(String s[])
	{
		SelectCMD obj=null;
		try{
			obj=new SelectCMD();
			obj.readData();
		}catch(Exception ex){System.out.println(ex.getMessage());}
		finally{
			try
			{
				if(obj.conn!=null)
				{
					obj.conn.close();
				}
			}catch(Exception e){}
		}//finally
	}
}//end class