/*
 program with use of PreparedStatement object
InsertData_2.java
*/
import java.sql.*;
class InsertSQL_2
{
	Connection conn=null;
	InsertSQL_2()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver loaded...");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");
		//System.out.println("connection opened...");

	}
	void insertData()throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("insert into student.std_tab(STDNAME,STDROLLNO,STDDEPT) values('AJAY KU',1002,'MCA')");
		boolean f=ps.execute();
		if(!f)
		{
			System.out.println("Data inserted...");
		}
		ps.close();
	}
	public static void main(String s[])
	{
		InsertSQL_2 obj=null;
		try{
			obj=new InsertSQL_2();
			obj.insertData();
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