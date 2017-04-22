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
public class CitySim {

    
    static City city = new City("Kristiansand", 10000);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        city.initialCitySize();
        city.passTime(365);
        System.out.println("People after 365 days:");
        city.getCityInfo();
    }
    
}
