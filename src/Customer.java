import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Customer {
	
	public static void main(String[] args) throws Exception {
	
		Connection connect = null;
     	Statement statement = null;
     	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
   
   // public void promptUser() throws Exception {
        try {
 
    Class.forName("com.mysql.jdbc.Driver");
    connect = DriverManager.getConnection("jdbc:mysql://localhost/Customers?user=root&password=password");
    statement = connect.createStatement();
    
    System.out.print("Enter the last name:");
    Scanner Input = new Scanner(System.in);
    String userIn = Input.nextLine();
    
    
    String sql = "SELECT CustomerID, Title, FullName, StreetAddress, City, State, ZipCode, EmailAddress, Cu_Position, Company from Customer where LastName =" +userIn+"";
    resultSet = statement.executeQuery(sql);
    //displayResultSet(resultSet);
    
    
        // It is possible to get the columns via name
        // also possible to get the columns via the column number
        // which starts at 1
        // e.g. resultSet.getSTring(2);
       int ID = resultSet.getInt("CustomerID");
        String title= resultSet.getString("Title");
        String fullname= resultSet.getString("FullName");
        String address= resultSet.getString("StreetAddress ");
        String city = resultSet.getString("City");
        String state = resultSet.getString("State");
        int zipcode = resultSet.getInt("ZipCode");
        String email = resultSet.getString("EmailAddress");
        String position = resultSet.getString("Cu_Position");
        String company = resultSet.getString("Company");
        /*Customer Number: 9
        Mr. Robert Dupree
        4101 Pickens Way
        Longview, TX 75601
        RobertODupree@einrot.com
        Mapping technician at Irving's Sporting Goods
        Press (1) to search for another customer or press (2) to Edit the customer's address.*/
        
        System.out.println("Customer Number: " + ID);
        System.out.println(title +"." +" "+ fullname);
        System.out.println(city +"," + ""+ state+""+zipcode);
        System.out.println(email);
        System.out.println(position + " at "+ company);
        System.out.println("Press (1) to search for another customer or press (2) to Edit the customer's address.");
    
    
        }catch(SQLException e){
			e.printStackTrace();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				resultSet.close();
				statement.close();
				connect.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
    }



}

