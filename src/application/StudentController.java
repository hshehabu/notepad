package application;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentController {

	@FXML
	private TextField student_id;
	@FXML
	private TextField student_name;
	@FXML
	private TextField student_grade;
	@FXML
	private Label error;
	String name,id,grade;
    public void save(ActionEvent e) throws IOException {
    	
    	name = student_name.getText().toString();
    	id = student_id.getText().toString();
    	grade = student_grade.getText().toString();
    	String string;
    	try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
			while((string = bufferedReader.readLine()) != null) {
				if(string.startsWith(id)) {
					error.setText("Duplicate entry");
				}
			}
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
  	
    	try {
        FileWriter fileWriter = new FileWriter("student.txt",true);
        fileWriter.append(id+"\t");
        fileWriter.append(name+"\t");
        fileWriter.append(grade+"\t");
        fileWriter.append("\n");
        fileWriter.flush();
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
}
