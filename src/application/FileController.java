package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class FileController {
@FXML
private Button logout , root , view;

@FXML
private TextArea textarea;
@FXML
private TextField url;
@FXML
private TreeView<String> treeView;
@FXML
private RadioButton three , five , ten;
int offset;
public void handleRadioButton(ActionEvent e) {
	if(three.isSelected()) {
		offset = 3;
	}
	else if(five.isSelected()) {
		offset = 5;
	}
	else if(ten.isSelected()) {
		offset = 10;
	}
}
	public void view() {
		String dir_url = url.getText().toString();
		
		File files = new File("C:\\Users\\hamza\\Desktop\\test");
		for(File f : files.listFiles()) {
			
			if(f.toString().equals(dir_url)) {
				if(f.isFile()) {
	                try {
	            		  FileReader reader = new FileReader(f.getAbsolutePath().toString());
	            	      BufferedReader buffer = new BufferedReader(reader);
	            	      StringBuilder builder = new StringBuilder();
	            	      String data="";
	            	      while((data = buffer.readLine())!=null) {
	            	    	  builder.append(data + "\n");
	            	      }
	            	      reader.close();
	            	      buffer.close();
	            	      textarea.setText(builder.toString());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
			{
				System.out.println("error");
			}
			
		}
	}
	public void listDirectory(){
		
			
//			treeView = new TreeView<String>();
			File desktop = new File("C:\\Users\\hamza\\Desktop\\test");
			treeView.setRoot(getNodesForDirectory(desktop));
		
		
	}
	  public TreeItem<String> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
	        TreeItem<String> root = new TreeItem<String>(directory.getName());
	        for(File file : directory.listFiles()) {
	            if(file.isDirectory()) { //Then we call the function recursively
	                root.getChildren().add(getNodesForDirectory(file));
	            } else {
	            	
	                root.getChildren().add(new TreeItem<String>(file.getAbsolutePath().toString()));

	            }
	        }
	        return root;
	    }
	  public void selectItem() {
		  
          TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
          if(item != null) {
        	File file = new File(item.getValue().toString());
        		  if(file.isFile()) {
        			  
        			  try {
        				  BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath().toString()));
        				  StringBuilder builder = new StringBuilder();
        				  String data="";
        				  while((data = bufferedReader.readLine()) != null) {
        					  builder.append(data + "\n");
        				  }
        				  bufferedReader.close();
        				  textarea.setText(builder.toString());
        				  
        				  
        				  
        			  } catch (IOException e1) {
        				  
        				  e1.printStackTrace();
        			  }
        		  }
        	  
//        	  File file = new File(item.getValue().toString());
//        	  try {
//        		  FileReader reader = new FileReader(file.getAbsolutePath().toString());
//        		  BufferedReader buffer = new BufferedReader(reader);
//        		  StringBuilder builder = new StringBuilder();
//        		  String data="";
//        		  while((data = buffer.readLine())!=null) {
//        			  builder.append(data + "\n");
//        		  }
//        		  reader.close();
//        		  buffer.close();
//        		  textarea.setText(builder.toString());
//        	  } catch (IOException e) {
//        		  
//        		  e.printStackTrace();
//        	  }
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

