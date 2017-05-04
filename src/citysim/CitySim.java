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
 *
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
    
    //static City city = new City("Kristiansand", 10000);
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        
        city.initialCitySize();
        city.passTime(365);
        System.out.println("People after 365 days:");
        city.getCityInfo();
    }
    */
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
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
