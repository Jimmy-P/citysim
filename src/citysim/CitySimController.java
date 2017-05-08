package citysim;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * Controller class for the "main" GUI screen. 
 * The purpose is to call the passTime method through the GUI button and display information about population
 * @author Jimmy
 */
public class CitySimController implements Initializable {
    //Declaring all our GUI elements
    @FXML
    private Text cityName;
    @FXML
    private Text oldMenNumber;
    @FXML
    private Text oldWomenNumber;
    @FXML
    private Text menNumber;
    @FXML
    private Text womenNumber;
    @FXML
    private Text boysNumber;
    @FXML
    private Text girlsNumber;
    @FXML
    private Text oldMenNumberNew;
    @FXML
    private Text oldWomenNumberNew;
    @FXML
    private Text menNumberNew;
    @FXML
    private Text womenNumberNew;
    @FXML
    private Text boysNumberNew;
    @FXML
    private Text girlsNumberNew;
    @FXML
    private Text oldMenNumberDead;
    @FXML
    private Text oldWomenNumberDead;
    @FXML
    private Text menNumberDead;
    @FXML
    private Text womenNumberDead;
    @FXML
    private Text boysNumberDead;
    @FXML
    private Text girlsNumberDead;
    @FXML
    private Button buttonPassTime;
    @FXML
    private Text textFeedback;
    @FXML
    private Text textGrowth;
    @FXML
    private Text textDeath;
    @FXML
    private Text textCurrent;
    @FXML
    private Text textPopulationHeader;
    @FXML
    private TextField textFieldNumberOfDays;
    @FXML
    private Text totalCurrent;
    @FXML
    private Text totalGrowth;
    @FXML
    private Text totalDeath;
    
    //Create a new City object to do the calculations and store data
    City city = new City();

    /**
     * Initializes the controller class.
     * Gets the name and population from the CitySim class, where it was stored when user pressed "Create city" and calls methods in the city
     * object to set the population and name to what was input in the text fields. 
     * Calls method in our city object for the initial city size, then sets the cityName GUI element by getting the String value from city object.
     * Finally calls updateNumbers method to display values from the city object in the GUI.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        city.setCityName(CitySim.getName());
        city.setPop((double)CitySim.getPop());
        city.initialCitySize();
        cityName.setText(city.getCityName());
        updateNumbers();
    }    
    /**
     * Method is called through event handling when buttonPassTime is pressed. 
     * Gets the string from the text field, ensures it is a whole number, then calls the passTime method in the city object with the parameter
     * as the number in textFieldNumberOfDays. Then calls the updateNumbers method to display new values in the GUI. 
     * If the String in textFieldNumberOfDays is not a whole number, an error message is created in textFeedback.
     */
    @FXML
    private void passTime(ActionEvent event) {
        
        
        if(isInteger(textFieldNumberOfDays.getText()) == true)
        {
            city.passTime(Integer.parseInt(textFieldNumberOfDays.getText()));
            updateNumbers();
        }
        
        else if(isInteger(textFieldNumberOfDays.getText()) == false)
        {
            textFeedback.setText("You must input a whole number");
        }
        
        
    
    }
    /**
     * This method gets values from the city object, for current population, growth and death of all demographics. 
     * It converts the ints to String to be able to display in a text GUI element.
     */
    public void updateNumbers()
    {
        oldMenNumber.setText(Integer.toString(city.getNumberOldMen()));
        oldWomenNumber.setText(Integer.toString(city.getNumberOldWomen()));
        menNumber.setText(Integer.toString(city.getNumberMen()));
        womenNumber.setText(Integer.toString(city.getNumberWomen()));
        boysNumber.setText(Integer.toString(city.getNumberBoys()));
        girlsNumber.setText(Integer.toString(city.getNumberGirls()));
        
        oldMenNumberDead.setText(Integer.toString(city.getDeadOldMen()));
        oldWomenNumberDead.setText(Integer.toString(city.getDeadOldWomen()));
        menNumberDead.setText(Integer.toString(city.getDeadMen()));
        womenNumberDead.setText(Integer.toString(city.getDeadWomen()));
        boysNumberDead.setText(Integer.toString(city.getDeadBoys()));
        girlsNumberDead.setText(Integer.toString(city.getDeadGirls()));
        
        oldMenNumberNew.setText(Integer.toString(city.getNewOldMen()));
        oldWomenNumberNew.setText(Integer.toString(city.getNewOldWomen()));
        menNumberNew.setText(Integer.toString(city.getNewMen()));
        womenNumberNew.setText(Integer.toString(city.getNewWomen()));
        boysNumberNew.setText(Integer.toString(city.getNewBoys()));
        girlsNumberNew.setText(Integer.toString(city.getNewGirls()));
        
        totalCurrent.setText(Integer.toString(city.getPop()));
        totalDeath.setText(Integer.toString(city.getTotalDeath()));
        totalGrowth.setText(Integer.toString(city.getTotalGrowth()));
        
        
                
    }
    
    //This method determines if a string parameter is an integer, returns true if so and returns false otherwise
    public boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
    
    
    
}
}
