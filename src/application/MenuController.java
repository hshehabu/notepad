package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	@FXML
	private Button student;
	@FXML
	private Button filepicker;
	@FXML
	private Button logout;
 public void studentManagement(ActionEvent e) {
	 Stage stage = (Stage) student.getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
	
 }
 public void filePicker(ActionEvent e) {
	 Stage stage = (Stage) filepicker.getScene().getWindow();
	 try {
		Parent root = FXMLLoader.load(getClass().getResource("File.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	} catch (IOException ex) {
		
		ex.printStackTrace();
	}
	 
 }
 public void notepad() {
	 NotepadController notepadController = new NotepadController();
	 notepadController.notepad();
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
