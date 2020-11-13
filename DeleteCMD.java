/*
 program TO DELETE ROW FROM TABLE
DeleteCMD.java
*/
import java.sql.*;
class DeleteCMD
{
	Connection conn=null;
	DeleteCMD()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver loaded...");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");
		//System.out.println("connection opened...");

	}
	void deleteData(int rn)throws SQLException
	{
		String sql="delete from student.std_tab where stdrollno=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,rn);
		int i=ps.executeUpdate();

		if(i==1)
		{
			System.out.println("student details deleted..");
		}else{
			System.out.println("No rollno found..");
		}

		ps.close();
	}
	public static void main(String s[])
	{
		DeleteCMD obj=null;
		try{
			obj=new DeleteCMD();
			obj.deleteData(Integer.parseInt(s[0]));
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