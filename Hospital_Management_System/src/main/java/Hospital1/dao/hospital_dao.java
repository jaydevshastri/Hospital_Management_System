package Hospital1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.bo.hospital1_bo;
import hospital.bo.hospital_bo;



public class hospital_dao 
{
	Connection con;
	public static Connection getConnection() 
	{
		Connection con=null;
		try 
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
	         
  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root", "root") ;
			
	}
		catch(Exception e) 
		{
			System.out.println(e);
			
	}
		return con;
	}//method

	   public static int signup(hospital_bo em) {
		   int status=0;
		   
		   try {
			  // Class.forName("com.mysql.cj.jdbc.Driver");
			   Connection con=hospital_dao .getConnection();
			   String sql="insert into signup(name,email,phone,password) values(?,?,?,?)";
			   PreparedStatement ps=con.prepareStatement(sql);
			   
			   ps.setString(1, em.getName());
			   ps.setString(2, em.getEmail());
			   ps.setString(3, em.getPhone());
			   ps.setString(4, em.getPassword());
			   status=ps.executeUpdate();
			   
			   
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   return status;
	   }
	   public static boolean userLogin(String email,String pass) {
		   boolean status=false;
		   try {
			   Connection con=hospital_dao .getConnection();
			   String sql="select * from signup where email=? And password=?";
			   PreparedStatement ps=con.prepareStatement(sql);
			   
			   ps.setString(1,email);
			   ps.setString(2,pass);
			   
			   ResultSet rs=ps.executeQuery();
			   status=rs.next();
			   		
		   }catch(Exception e) {
			   System.out.println(e);
			   
		   }
		   return status;
		  
	   }
	   public static int Addpatient(hospital1_bo eb) {
		   int status=0;
		   
		   try {
			   Connection con=hospital_dao .getConnection();
			   String query="insert into addpatient(id,name,email,phone,dob,diseased,blood_group) values(?,?,?,?,?,?,?)";
			   PreparedStatement ps=con.prepareStatement(query);
			   
			   ps.setInt(1, eb.getId());
			   ps.setString(2, eb.getName());
			   ps.setString(3, eb.getEmail());
			   ps.setString(4, eb.getPhone());
			   ps.setString(5, eb.getDob());
			   ps.setString(6, eb.getDiseased());
			   ps.setString(7, eb.getBlood_group());
			   
			   
			   status=ps.executeUpdate();
			   
		   }catch(Exception e) {
			   System.out.println(e);
		 
			   
		   }
		   return status;
		   
	   }
	  

	public static List getAllpatient() {
		   List list=new ArrayList();
		   
		   try {
			   Connection con=hospital_dao.getConnection();
			   PreparedStatement ps=con.prepareStatement("select * from addpatient");
			   ResultSet rs=ps.executeQuery();
			   
			   while(rs.next()) {
				   hospital1_bo eb=new hospital1_bo();
				   
				   eb.setId(rs.getInt(1)); 
				   eb.setName(rs.getString(2));
				   eb.setEmail(rs.getString(3));
				   eb.setPhone(rs.getString(4));
				   eb.setDob(rs.getString(5));
				   eb.setDiseased(rs.getString(6));
				   eb.setBlood_group(rs.getString(7));
				   
				   
                    list.add(eb);				   
			   }
		   } catch(Exception e) {
			   System.out.println(e);
				   
				   
			   }
			   return list;
		   }
	   public static hospital1_bo getEmployeeById(int id) {
		   hospital1_bo eb=new hospital1_bo();
		   try {
			   Connection con=hospital_dao.getConnection();
			   String query="select * from addpatient where id=?";
			   
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setInt(1, id);
			   
			   ResultSet rs=ps.executeQuery();
			   
			  if(rs.next()) {
				  
				   eb.setId(rs.getInt(1)); 
				   eb.setName(rs.getString(2));
				   eb.setEmail(rs.getString(3));
				   eb.setPhone(rs.getString(4));
				   eb.setDob(rs.getString(5));
				   eb.setDiseased(rs.getString(6));
				   eb.setBlood_group(rs.getString(7));
				   }
			   
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   
	   
	   return eb;
		   
	   }
	   
	   public static int Update(hospital1_bo eb) {
		   int status=0;
		   
		   try {
			   Connection con=hospital_dao.getConnection();
			   String Query="update addpatient set name=?,Email=?,Phone=?,dob=?,diseased=?,blood_group=? where id=?";
			   PreparedStatement ps=con.prepareStatement(Query);
			   
			   ps.setString(1, eb.getName());
			   ps.setString(2, eb.getEmail());
			   ps.setString(3, eb.getPhone());
			   ps.setString(4, eb.getDob());
			   ps.setString(5, eb.getDiseased());
			   ps.setString(6, eb.getBlood_group());
			   ps.setInt(7,eb.getId());

			  
			   
			   status=ps.executeUpdate();
		   }catch(Exception e) 
		   {
			   System.out.println(e);
	   }

	   
		   return status;
	   }
	   public static int delete(int id) {
		   int status=0;
		   try {
			   Connection con=hospital_dao.getConnection();
			   String Query="Delete  from addpatient where id=?";
			   PreparedStatement ps=con.prepareStatement(Query);
			   
			  ps.setInt(1, id);
			   
			   status=ps.executeUpdate();
			   
			   
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		   return status;
	   }

}