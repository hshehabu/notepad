package application;



import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FileController {
@FXML
private Button logout;
	public void view(){
		try {
			Label label = new Label();
			label.setText("Select dirs");
			TextArea textarea = new TextArea();
			
			
			File folder = new File("C:\\Users\\Desktop");
			File[] files = folder.listFiles();
		
			for(File file:files) {
				if(file.isFile()) {
					textarea.setText("     " + file.getName());
				}
				else if(file.isDirectory()) {
					textarea.setText("->" + file.getName());
				}
			}
			
			Stage stage = new Stage();
			Group root = new Group();
			root.getChildren().add(label);
//			Parent root = FXMLLoader.load(getClass().getResource("File.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("file chooser");
			stage.setHeight(400);
			stage.setWidth(600);
		    stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	    
		
		
	}
	 public void logout() {
		 Stage stage = (Stage) logout.getScene().getWindow();
		 try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
	 }
}
