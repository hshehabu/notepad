package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

String uname , pword;
//void setCredentials(String username , String password){
//	this.uname = username;
//	this.pword = password;
//}

	public void submit(ActionEvent e) throws IOException {
		
		uname = "1";
		pword = "1";
	
		if(username.getText().toString().equals(uname) && password.getText().toString().equals(pword)) {
			Stage stage = (Stage) username.getScene().getWindow();
//			stage.close();
			Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
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
