

package inventory;
import java.sql.*;
import java.util.ArrayList;

import branch.Branch;


public class InventoryModel {

	
	private Statement statement;
	private PreparedStatement ps;
	private static Connection connection;
	
	
	public InventoryModel() {
		super();
		this.statement = statement;
		this.ps = ps;
		this.connection = connection;
	}
	
	public static void initJDBC() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loadedd");

// Connect to database
       connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/sampledb2" , "root", "");
        System.out.println("Database connect");
	}
	
	public static ArrayList<Inventory> viewInventory() throws ClassNotFoundException, SQLException
	{
		initJDBC();
		
		ArrayList<Inventory> ivList = null;
		
		try {


	       ivList = new ArrayList<Inventory>();

	        Statement statement = connection.createStatement();


	        ResultSet rs = statement.executeQuery("SELECT * FROM delivery");

	        while (rs.next()){

	            Inventory iv = new Inventory();

	            iv.setTrackno(rs.getString("track_no"));

	     

	            iv.setSendname(rs.getString("sendername"));

	            iv.setSendadd(rs.getString("senderadd"));

	

	            iv.setRecadd(rs.getString("recadd"));

	            ivList.add(iv);

	    }
	        
	    }
		
		
		
	    catch (Exception ex) {

	        System.out.println("viewInventory():"+ ex);
	        ex.printStackTrace();
	    }
		
	
		return ivList;	
	} 
	
	public Inventory getInventoryById (String trackno) throws ClassNotFoundException, SQLException{
		   initJDBC();
		   Inventory iv = new Inventory();
		try{ 
			
			 // Create statement to get query
			 statement = connection.createStatement();
						
			 // Execute a query		
			 String selectbyId = "SELECT * FROM delivery WHERE trackno = " + trackno ;
			 ResultSet rs = statement.executeQuery(selectbyId);
          
			    rs.next();
			    
			    iv.setTrackno(rs.getString("trackno"));
				iv.setSendname(rs.getString("sendername"));
				iv.setSendadd(rs.getString("senderadd"));
				iv.setRecadd(rs.getString("recadd"));

			
				
			connection.close();
		}
		
		catch (Exception ex){
			System.out.println("getInventoryById(): " + ex);
			ex.printStackTrace();
		}
	 return iv;
	} 
	   

	public void updateInventory(Inventory iv) throws ClassNotFoundException, SQLException{

        initJDBC();

        try {

            String sql = "UPDATE delivery SET track_no = ?,sendname = ?,sendadd =? ,recadd =? WHERE track_no = ?";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, iv.getTrackno());
         
            ps.setString(2,  iv.getSendname()); 
            ps.setString(3, iv.getSendadd());
          
            ps.setString(4, iv.getRecadd());

       

            ps.executeUpdate();
            System.out.println("Database updated successfully ");
        }
        catch (Exception ex) {
            System.out.println("updateInventory()" + ex);
            ex.printStackTrace();
        }
    }

    public void deleteInventoryById(String trackno)  throws ClassNotFoundException, SQLException{

        try {

            initJDBC();
            String sql = ("DELETE from delivery WHERE track_no = ?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trackno);

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
        }
        catch (Exception ex) {
            System.out.println("deleteInventoryById(): "+ ex);
            ex.printStackTrace();
        }
    }
    
    
    
    public void addInventory(Inventory iv) throws ClassNotFoundException, SQLException{

        initJDBC();

        try {

            String sql = "INSERT INTO `delivery`(`track_no`, `sendername`, `senderadd`, `recadd`) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, iv.getTrackno());
        
            ps.setString(2, iv.getSendname()); 
            ps.setString(3, iv.getSendadd());
           
            ps.setString(4, iv.getRecadd());
           

            ps.executeUpdate();
            System.out.println("New record added successfully ");
        }
        catch (Exception ex) {
            System.out.println("addInventory()" + ex);
            ex.printStackTrace();
        }
    }
}

