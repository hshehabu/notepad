package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.*;


public class Main extends Application {
	
	static String username , password;//allocate memory once******
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
	}	
		    catch(Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) throws Exception {
//		String url = "jdbc:mysql://localhost:3306/lab-exercise";
//		String user = "root";
//		String pw = "";
//		String query = "select * from user";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection(url, user, pw);
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery(query); // Execute query
//        resultSet.next();
//        username = resultSet.getString("username"); // Retrieve name from db
//        password = resultSet.getString("password"); // Retrieve name from db
//     
//        statement.close(); // close statement current result set ,  if exists , also get closed
//        con.close(); // close connection
        
       launch(args);
		
	}
	
}
