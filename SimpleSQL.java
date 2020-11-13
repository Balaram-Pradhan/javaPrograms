/*
simple jdbc-odbc program with mysql server
SimpleSQL.java
*/
import java.sql.*;
class SimpleSQL
{
	Connection conn=null;
	SimpleSQL()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded...");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");
		System.out.println("connection opened...");

	}
	void insertData()throws SQLException
	{
		Statement st=conn.createStatement();
		boolean f=st.execute("insert into student.(STDNAME,STDDEPT) values('Balaram pradhan','MCA')");
		if(!f)
		{
			System.out.println("Data inserted...");
		}
		st.close();
	}
	public static void main(String s[])
	{
		SimpleSQL obj=null;
		try{
			obj=new SimpleSQL();
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