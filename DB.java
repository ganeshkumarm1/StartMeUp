import java.sql.*;
public class DB
{
	//Login 
	public String login(String email,String password)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection	c = DriverManager.getConnection("jdbc:odbc:SMU");
			Statement st=c.createStatement();
			ResultSet rs = st.executeQuery("SELECT email,password from register");
			while(rs.next())
			{
				String temp_email=rs.getString(1);
				String temp_password=rs.getString(2);
				if((temp_email.equals(email))&&(temp_password.equals(password)))
				{
					return temp_email;
				}
			}
		return "";
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "";
	}

	//Register
	public int register(String name,String email,String password,String mobile,String country)
	{
		
		try
		{
			int var;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection	c = DriverManager.getConnection("jdbc:odbc:SMU");
			Statement st=c.createStatement();
			ResultSet rs = st.executeQuery("SELECT email FROM register");
			if(rs!=null)
			{
				while(rs.next())
				{
					String e_email=rs.getString(1);
					if(e_email.equals(email))
					{
						return 2;
					}
				}
			}	
			PreparedStatement s = c.prepareStatement("INSERT INTO register (names,email,password,mobile,country) VALUES (?,?,?,?,?)");
			s.setString(1,name);
			s.setString(2,email);
			s.setString(3,password);
			s.setString(4,mobile);
			s.setString(5,country);
			var=s.executeUpdate();
			System.out.println(var);
			c.close();
			return var;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return 0;
	}

	//Upload
	public int upload(String title,String category,String details)
	{
			int var=0;
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
				Connection	c = DriverManager.getConnection("jdbc:odbc:SMU");
				PreparedStatement s = c.prepareStatement("INSERT INTO upload (job,category,details) VALUES (?,?,?)");
				s.setString(1,title);
				s.setString(2,category);
				s.setString(3,details);
				var=s.executeUpdate();
				c.close();
				return var;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return 0;
	}

	//Search
	public String search(String category)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //Or any other driver
			Connection	c = DriverManager.getConnection("jdbc:odbc:SMU");
			Statement st=c.createStatement();
			ResultSet rs = st.executeQuery("SELECT job_id,job,details,category from upload");
			while(rs.next())
			{
				String temp_job_id=rs.getString(1);
				String temp_job=rs.getString(2);
				String temp_details=rs.getString(3);
				String temp_category=rs.getString(4);
				String return_string;
				if(temp_category.equals(category))
				{
					return_string=temp_job_id+"\n"+temp_job+"\n"+temp_details+"\n";
					return return_string;
				}
				
			}
		return null;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	//Apply
	public int apply(String id,String email)	
	{
		try
		{
			int var;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			Connection	c = DriverManager.getConnection("jdbc:odbc:SMU");
			PreparedStatement s = c.prepareStatement("INSERT INTO apply (email,job_id) VALUES (?,?)");
			s.setString(1,email);
			s.setString(2,id);
			var=s.executeUpdate();
			c.close();
			return var;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
}