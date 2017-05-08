/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citysim;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
/**
 * This is the main class of the program, which declares the stage and stores the city name and
 * initial population from they are entered in the first GUI screen. The class also instantiates a
 * sceneselecter, allowing us to navigate through the GUI using the GUI elements (In our case, a button)
 * @author Jimmy
 */
public class CitySim extends Application{
    
    
    private static String name;
    private static int initPop;
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        SceneSelecter ss = new SceneSelecter();
        ss.start(stage);
    }
   
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    //This method sets the initial population  value and the city name
    public static void setInitValues(String name, String pop){
        CitySim.name = name;
        initPop = Integer.parseInt(pop);
        
    }
    public static int getPop(){
        return initPop;
    }
    public static String getName(){
        return name;
    }
    
}
