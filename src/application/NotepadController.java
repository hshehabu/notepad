package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NotepadController {

	public void notepad() {
		MenuBar menubar = new MenuBar();
		
		Menu file = new Menu("file");
		Menu help = new Menu("help");
		
		MenuItem open = new MenuItem("open");
		MenuItem save = new MenuItem("save");
		MenuItem exit = new MenuItem("exit");
		
		MenuItem picker = new MenuItem("file picker");
		
		file.getItems().addAll(open,save,exit);
		help.getItems().addAll(picker);
		
		menubar.getMenus().addAll(file,help);
		
		TextArea textarea = new TextArea();
		textarea.setMaxHeight(400);
		textarea.setMaxWidth(400);
		
		save.setOnAction(ActionEvent->{
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("txt files", ".txt");
			File saveFile = fileChooser.showSaveDialog(null);
			try {
				FileWriter fileWriter = new FileWriter(saveFile);
				fileWriter.write(textarea.getText());
				fileWriter.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		});
		open.setOnAction(ActionEvent->{
			FileChooser fileChooser2 = new FileChooser();
			FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("txt files", ".txt");
			File openFile = fileChooser2.showOpenDialog(null);
		
	 
			try {
	      FileReader reader = new FileReader(openFile.getAbsolutePath().toString());
	      BufferedReader buffer = new BufferedReader(reader);
	      StringBuilder builder = new StringBuilder();
	      String data="";
	      while((data = buffer.readLine())!=null) {
	    	  builder.append(data + "\n");
	      }
	      reader.close();
	      buffer.close();
	      textarea.setText(builder.toString());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		});
		exit.setOnAction(ActionEvent->{
			System.exit(0);
		});
		picker.setOnAction(ActionEvent->{
			FileController filePicker = new FileController();
		});
		GridPane grid = new GridPane();
		grid.add(menubar, 0, 0);
		grid.add(textarea, 0, 1);
		Group root = new Group();
		root.getChildren().add(grid);
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		stage.setMaxHeight(400);
		stage.setMaxWidth(600);
		stage.setTitle("Notepad");
		stage.setScene(scene);
		stage.show();
	}
	
}
