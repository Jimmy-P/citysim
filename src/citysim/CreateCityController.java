package citysim;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Names.ViewNames;
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
 *Controller class for the first GUI screen.
 * @author Jimmy
 */
public class CreateCityController implements Initializable {

    @FXML
    private Button buttonCreateCity;
    @FXML
    private TextField textfieldCityName;
    @FXML
    private TextField textfieldPopulation;
    @FXML
    private Text createCityText;
    @FXML
    private Text textFeedback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //This method is called through event handling when buttonCreateCity is pressed
    //It checks if the text in textfieldPopulation is an int, if not gives an error message, if so goes ahead and sets
    //the initial population and name variables and switches to the next scene
    @FXML
    private void createCity(ActionEvent event) throws Exception{
        
        if(isInteger(textfieldPopulation.getText()) == true)
        {
        
        CitySim.setInitValues(textfieldCityName.getText(), textfieldPopulation.getText());
        
        SceneSelecter.getInstance().setScene(ViewNames.cityView);
        }
        else if(isInteger(textfieldPopulation.getText()) == false)
        {
            textFeedback.setText("Population must be a whole number");
        }
        
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
