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
 *
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createCity(ActionEvent event) throws Exception{
        
        CitySim.setInitValues(textfieldCityName.getText(), textfieldPopulation.getText());
        
        SceneSelecter.getInstance().setScene(ViewNames.cityView);
    }
    
}
