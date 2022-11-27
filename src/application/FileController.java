package application;



import java.io.File;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FileController {
	FileController(){
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
}
