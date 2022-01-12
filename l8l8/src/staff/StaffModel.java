package staff;

import java.sql.* ;
import java.sql.Date;
import java.util.*;
import staff.Staff;

public class StaffModel {

	private Statement statement;
	private PreparedStatement ps;
	private Connection connection;
	
	public StaffModel () {
		// TODO Auto-generated constructor stub
	}
	
	public void initJDBC () throws ClassNotFoundException, SQLException {
	        
		    //STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 2: Open a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb2" , "root", "");
	}
	
	//view all record
	public ArrayList<Staff> viewStaff() throws ClassNotFoundException, SQLException{
		
		initJDBC();
		ArrayList<Staff> ivList = null;
		
		try {
			ivList = new ArrayList<Staff>();
			
			// Create statement to get query
			statement = connection.createStatement();
			
			// Execute a query
			ResultSet rs = statement.executeQuery("SELECT * FROM staff");
			
			//STEP 6: Extract data from result set
			while (rs.next()){
				Staff iv = new Staff();
				iv.setStaffid(rs.getInt("staff_id"));
				iv.setStaffname(rs.getString("staff_name"));
				iv.setStafftel(rs.getString("staff_tel"));
				iv.setStaffpos(rs.getString("staff_pos"));
				iv.setStaffbranch(rs.getInt("branchid"));
				ivList.add(iv);
			}
			
			connection.close();
		}
		
		catch (Exception ex) {
			System.out.println("viewStaff(): " + ex);
			ex.printStackTrace();
		}
		
		return ivList;
		
	}
	
	//add a record
	public void addStaff(Staff iv) throws ClassNotFoundException, SQLException{
		initJDBC();
		try{
			
			//create statement to insert into table
			String insert = "INSERT into staff(staff_id,staff_name,staff_tel,staff_pos,branchid) values(?,?,?,?,?)";
			//Create statement to get query
			 ps = connection.prepareStatement(insert);
	          
			  // create the value for each column
			 	ps.setInt(1, iv.getStaffid());
				ps.setString(2, iv.getStaffname());
				ps.setString(3, iv.getStafftel());
				ps.setString(4, iv.getStaffpos());
				ps.setInt(5, iv.getStaffbranch());
			  
		      
		      //execute prepared statement
		      ps.executeUpdate();
		      System.out.println("A record inserted successfully ");
			  connection.close();
			
		}
		catch (Exception ex){
			System.out.println("addStaff(): " + ex);
			ex.printStackTrace();
		}
		
	}
	
	   //select specific record
	   public Staff getStaffById (int id) throws ClassNotFoundException, SQLException{
		   initJDBC();
		   Staff iv = new Staff();
		try{ 
			
			 // Create statement to get query
			 statement = connection.createStatement();
						
			 // Execute a query		
			 String selectbyId = "SELECT * FROM staff WHERE staff_id = " + id ;
			 ResultSet rs = statement.executeQuery(selectbyId);
             
			    rs.next();
			    
			    iv.setStaffid(rs.getInt("staff_id"));
				iv.setStaffname(rs.getString("staff_name"));
				iv.setStafftel(rs.getString("staff_tel"));
				iv.setStaffpos(rs.getString("staff_pos"));
				iv.setStaffbranch(rs.getInt("branchid"));
			
				
			connection.close();
		}
		
		catch (Exception ex){
			System.out.println("getStaffById(): " + ex);
			ex.printStackTrace();
		}
	 return iv;
	} 
	   
	 //select update specific record
	   public void updateStaff(Staff iv) throws ClassNotFoundException, SQLException{
			
			initJDBC();
			//java.util.Date utilDate = iv.getorders_date();
			//Date sqlDate = new java.sql.Date(utilDate.getTime());
			try {
				
				String sql = "UPDATE staff SET staff_id= ?,staff_name = ?,staff_tel = ?, staff_pos = ?, branchid = ? WHERE staff_id = ?";
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1, iv.getStaffid());
				ps.setString(2, iv.getStaffname());
				ps.setString(3, iv.getStafftel());
				ps.setString(4, iv.getStaffpos());
				ps.setInt(5, iv.getStaffbranch());
				ps.setInt(6, iv.getStaffid());
				ps.executeUpdate();
				
	            
	            System.out.println("Database updated successfully ");
	            
			}
			catch (Exception ex) {
				System.out.println("updateStaff()" + ex);
				ex.printStackTrace();
			}
		}
	   
	   public void deleteStaffById(int id)  throws ClassNotFoundException, SQLException{
			
			try {	
				
				this.initJDBC();
				String sql = ("DELETE from staff WHERE  staff_id = ?");
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				
				ps.executeUpdate();
				System.out.println("Record deleted successfully");
			}
			catch (Exception ex) {
				System.out.println("deleteStaffById(): "+ ex);
				ex.printStackTrace();
			}
		}
	   
	   
}
	


