
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citysim;


import Names.ViewNames;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Class to let us change scenes in the GUI
 * @author Kjetil
 */
public class SceneSelecter extends Application {
    
    //Declares a stage and a SceneSelecter instance
    //Creates a hashmap with values from the ViewNames class, and their corresponding FXML in order to swap between the scenes
    private Stage stage; 
    private static SceneSelecter instance;
    private HashMap<String, String> views = new HashMap<String, String>()
    {
        {
            put(ViewNames.createView, "CreateCity.fxml");
            put(ViewNames.cityView, "CitySim.fxml"); 
        }
        
    }; 
    
    public SceneSelecter() 
    {
        instance = this;
    }
    
    public static SceneSelecter getInstance() 
    {
        return instance; 
    }
    //This method takes a stage as a parameter, and sets the scene in that stage to createView through the setScene method. 
    @Override
    public void start(Stage primaryStage) {
        try 
        {
            
            //Stage stage = new Stage();
            this.stage = primaryStage; 
            this.setScene(ViewNames.createView);

            this.stage.show();
            
            
        }
        catch (Exception e) 
        {
            
            e.printStackTrace();
        }
    }

    /**
     * 
     * This method takes a String parameter and first checks if the views hashmap contains a String with the same value as the parameter, and if so calls 
     * the replaceSceneContent method with that same String as a parameter. An exception is thrown if the hashmap has no such value.
     */
    public void setScene(String value) throws Exception
    {
        if(this.views.containsKey(value))
        {
            this.replaceSceneContent(this.views.get(value)); 
        }
        else 
            throw new Exception("Value does not exist"); 
    }
    
    /**
     * Based on : http://stackoverflow.com/questions/13003323/javafx-how-to-change-stage
     * This method is more or less copied from the JavaFX sample project. 
     * It works.
     * @throws Exception 
     */
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(SceneSelecter.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
    