package branch;

import java.sql.* ;
import java.sql.Date;
import java.util.*;
import branch.Branch;

public class BranchModel {

	private Statement statement;
	private PreparedStatement ps;
	private Connection connection;
	
	public BranchModel () {
		// TODO Auto-generated constructor stub
	}
	
	public void initJDBC () throws ClassNotFoundException, SQLException {
	        
		    //STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 2: Open a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb2" , "root", "");
	}
	
	//view all record
	public ArrayList<Branch> viewBranch() throws ClassNotFoundException, SQLException{
		
		initJDBC();
		ArrayList<Branch> ivList = null;
		
		try {
			ivList = new ArrayList<Branch>();
			
			// Create statement to get query
			statement = connection.createStatement();
			
			// Execute a query
			ResultSet rs = statement.executeQuery("SELECT * FROM branch");
			
			//STEP 6: Extract data from result set
			while (rs.next()){
				Branch iv = new Branch();
				iv.setId(rs.getInt("branch_id"));
				iv.setState(rs.getString("branch_state"));
				iv.setTel(rs.getString("branch_tel"));
				iv.setAddress(rs.getString("branch_address"));

				ivList.add(iv);
			}
			
			connection.close();
		}
		
		catch (Exception ex) {
			System.out.println("viewBranch(): " + ex);
			ex.printStackTrace();
		}
		
		return ivList;
		
	}
	
	//add a record
	public void addBranch(Branch iv) throws ClassNotFoundException, SQLException{
		initJDBC();
		try{
			
			//create statement to insert into table
			String insert = "INSERT into branch(branch_id,branch_state,branch_tel,branch_address) values(?,?,?,?)";
			//Create statement to get query
			 ps = connection.prepareStatement(insert);
	          
			  // create the value for each column
			 	ps.setInt(1, iv.getId());
				ps.setString(2, iv.getState());
				ps.setString(3, iv.getTel());
				ps.setString(4, iv.getAddress());
		
			  
		      
		      //execute prepared statement
		      ps.executeUpdate();
		      System.out.println("A record inserted successfully ");
			  connection.close();
			
		}
		catch (Exception ex){
			System.out.println("addBranch(): " + ex);
			ex.printStackTrace();
		}
		
	}
	
	   //select specific record
	   public Branch getBranchById (int id) throws ClassNotFoundException, SQLException{
		   initJDBC();
		   Branch iv = new Branch();
		try{ 
			
			 // Create statement to get query
			 statement = connection.createStatement();
						
			 // Execute a query		
			 String selectbyId = "SELECT * FROM branch WHERE branch_id = " + id ;
			 ResultSet rs = statement.executeQuery(selectbyId);
             
			    rs.next();
			    
			    iv.setId(rs.getInt("branch_id"));
				iv.setState(rs.getString("branch_state"));
				iv.setTel(rs.getString("branch_tel"));
				iv.setAddress(rs.getString("branch_address"));

			
				
			connection.close();
		}
		
		catch (Exception ex){
			System.out.println("getBranchById(): " + ex);
			ex.printStackTrace();
		}
	 return iv;
	} 
	   
	 //select update specific record
	   public void updateBranch(Branch iv) throws ClassNotFoundException, SQLException{
			
			initJDBC();
			//java.util.Date utilDate = iv.getorders_date();
			//Date sqlDate = new java.sql.Date(utilDate.getTime());
			try {
				
				String sql = "UPDATE branch SET branch_id= ?,branch_state = ?,branch_tel = ?, branch_address = ? WHERE branch_id = ?";
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1, iv.getId());
				ps.setString(2, iv.getState());
				ps.setString(3, iv.getTel());
				ps.setString(4, iv.getAddress());
				ps.setInt(5, iv.getId());
				System.out.println(iv.getId());
				ps.executeUpdate();
				
	            
	            System.out.println("Database updated successfully ");
	            
			}
			catch (Exception ex) {
				System.out.println("updateBranch()" + ex);
				ex.printStackTrace();
			}
		}
	   
	   public void deleteBranchById(int id)  throws ClassNotFoundException, SQLException{
			
			try {	
				
				this.initJDBC();
				String sql = ("DELETE from branch WHERE  branch_id = ?");
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				
				ps.executeUpdate();
				System.out.println("Record deleted successfully");
			}
			catch (Exception ex) {
				System.out.println("deleteBranchById(): "+ ex);
				ex.printStackTrace();
			}
		}
	   
	   
}
	

