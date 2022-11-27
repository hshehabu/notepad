package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
@FXML
private Button submit;
@FXML
private Button cancel;
@FXML
private TextField username;
@FXML
private PasswordField password;
@FXML
private Label error;
@FXML
private Stage stage;
@FXML
private Scene scene;
@FXML
private Parent root;

	
	public void submit(ActionEvent e) throws IOException {
		NotepadController notepad = new NotepadController();
		if(username.getText().toString().equals("1") && password.getText().toString().equals("1")) {
//			Parent root = FXMLLoader.load(getClass().getResource("Notepad.fxml"));
//			stage =(Stage)((Node)e.getSource()).getScene().getWindow();
//			scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
			Stage stage1 = (Stage) username.getScene().getWindow();
		    stage1.close();
			notepad.notepad();
		}
		else if(username.getText().isEmpty() && !password.getText().isEmpty()) {
			error.setText("please enter username");
		}
		else if(!username.getText().isEmpty() && password.getText().isEmpty()) {
			error.setText("please enter password");
		}
		else if(username.getText().isEmpty() && password.getText().isEmpty()) {
			error.setText("please enter your data");
		}
		else {
			error.setText("wrong credentials");
		}
		
	}
	public void cancel(ActionEvent e) throws IOException{
		System.exit(0);
	}
	
}
