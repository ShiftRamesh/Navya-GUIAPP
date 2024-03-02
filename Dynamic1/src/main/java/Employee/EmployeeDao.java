package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDao {

	 public int registerEmployee(Employee employee) throws ClassNotFoundException 
	 {
		  String INSERT_USERS_SQL="INSERT INTO employee values(?, ?, ?, ?, ?,?,?)";
		  int result = 0;
		  try 
		 {
			   
			 Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				
				System.out.println(con);
				
				PreparedStatement pst=con.prepareStatement(INSERT_USERS_SQL);
				
				    pst.setInt(1, 1);
		            pst.setString(2, employee.getFirstName());
		            pst.setString(3, employee.getLastName());
		            pst.setString(4, employee.getUsername());
		            pst.setString(5, employee.getPassword());
		            pst.setString(6, employee.getAddress());
		            pst.setString(7, employee.getContact());
				
		            System.out.println(pst);
		            // Step 3: Execute the query or update query
		            result = pst.executeUpdate();
		 }
		 catch (Exception e) {
			e.printStackTrace();
			}
		return result ;
		 
	 }

}
