/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citysim;

/**
 *
 * @author Jimmy
 */
public class Building {
    
    private String building;
    private String buildingName;
    
    public Building(String building){
        
        switch(building){
            case "hospital":
                setEffect("hospital");
        }
        
        
    }
    private void setEffect(String building)
    {
        buildingName = building;
        
        switch (buildingName) {
        case"hospital": 
            
        }
        
    }
    
}


