/*
 program TO put dynamic value
InsertData_3.java
*/
import java.sql.*;
class InsertSQL_3
{
	Connection conn=null;
	InsertSQL_3()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver loaded...");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");
		//System.out.println("connection opened...");

	}
	void insertData(String nm,int rn,String dept)throws SQLException
	{
		String sql="insert into student.std_tab(STDNAME,STDROLLNO,STDDEPT) values('"+nm+"',"+rn+",'"+dept+"')";
		PreparedStatement ps=conn.prepareStatement(sql);
		boolean f=ps.execute();
		if(!f)
		{
			System.out.println("Data inserted...");
		}
		ps.close();
	}
	public static void main(String s[])
	{
		InsertSQL_3 obj=null;
		try{
			obj=new InsertSQL_3();
			obj.insertData(s[0],Integer.parseInt(s[1]),s[2]);
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