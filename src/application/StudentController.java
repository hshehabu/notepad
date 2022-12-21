package application;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentController {

	@FXML
	private TextField student_id;
	@FXML
	private TextField student_name;
	@FXML
	private TextField student_grade;
	@FXML
	private Button logout;
	@FXML
	private Label error;
	String name,id,grade;
	
	
    public void save(ActionEvent e) throws IOException {
    	
    	boolean pause = false;
    	String decimalPattern = "([0-9]*)\\.([0-9]*)";
    	String namePattern = "[a-zA-Z]*";
    	name = student_name.getText().toString();
    	id = student_id.getText().toString();
    	grade = student_grade.getText().toString();
    	String string;
    	
    	//Check validity of name without space
    	
    	if( !Pattern.matches(namePattern, name)) {
    		error.setText("Invalid name format");
    		pause = true;
    	}
    	
    	//Check validity of grade format*****************
    	
    	if( !Pattern.matches(decimalPattern, grade)) {
    		error.setText("Invalid grade format");
    		pause = true;
    	}
    	
    	//Check for duplicate entry***********************
    	
    	try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
			while((string = bufferedReader.readLine()) != null) {
				if(string.startsWith(id)) {
					
					error.setText("Duplicate entry");
					pause = true;
				}
			}
			bufferedReader.close();
			
		//If all fine*******************
			
			if(pause == false) {
				
				FileWriter fileWriter = new FileWriter("student.txt",true);
				fileWriter.append(id+"\t");
				fileWriter.append(name+"\t");
				fileWriter.append(grade+"\t");
				fileWriter.append("\n");
				fileWriter.flush();
				fileWriter.close();
			}
    	}
    	catch(IOException ex) {
    		System.out.println(ex.getMessage());
    	}
    }
    public void view(ActionEvent e) throws IOException {
    	String string;
    	id = student_id.getText().toString();
    	try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
			while((string = bufferedReader.readLine()) != null) {
				if(string.startsWith(id)) {
					String [] array = string.split("\t");
					student_id.setText(array[0]);
					student_name.setText(array[1]);
					student_grade.setText(array[2]);
					error.setText(string);
				}
				
			}
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
    }
    public void cancel(ActionEvent e) {
    	student_id.setText("");
    	student_name.setText("");
    	student_grade.setText("");
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
