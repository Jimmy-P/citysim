package citysim;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
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
public class CitySimController implements Initializable {

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
    private Button buttonCreateCity;
    @FXML
    private TextField textfieldCityName;
    @FXML
    private TextField textfieldPopulation;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        City city = new City(CitySim.getName(), CitySim.getPop());
        cityName.setText(city.getCityName());
    }    
    
    
    
    
    
}
