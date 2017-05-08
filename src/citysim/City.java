/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citysim;



/**
 *The City class is the central class in the program. It keeps track of all information
 * and changes. Most variables are doubles because it is necessary to calculate
 * percentages, and because of the nature of the passTime method it is important to keep decimal
 * values stored. All display values are converted to int.
 * @author Jimmy
 */
public class City {


private String cityName;
private double totalPopulation;
private double percentElders;
private double percentAdults;
private double percentChildren;
private int daysPerYear = 365;

//Ints to display the number of different demographics
private int numberOldMen;
private int numberOldWomen;
private int numberMen;
private int numberWomen;
private int numberBoys;
private int numberGirls;


//Doubles to keep track of the number of different demographics.
private double doubleNumberOldMen;
private double doubleNumberOldWomen;
private double doubleNumberMen;
private double doubleNumberWomen;    
private double doubleNumberBoys;  
private double doubleNumberGirls;   
        
//Various variables set to default values
private double elderMortality = 0.2;
private double adultMortality = 0.025;
private double childMortality = 0.05;

private double adultsAging = 0.15;
private double childrenAging = 0.3;
private double birthRate = 0.45;

private double percentFemale = 0.503;
private double percentMale = 0.497;

private double percentWealthy = 0.03;
private double percentMiddleClass = 0.27;
private double percentPoor = 0.7;


//Variables for tracking death and growth 
private double deadOldMen;
private double deadOldWomen;
private double deadMen;
private double deadWomen;
private double deadBoys;
private double deadGirls;
private double newOldMen;
private double newOldWomen;
private double newMen;
private double newWomen;
private double newBoys;
private double newGirls;

private int totalDeath;
private int totalGrowth;

//Constructor simply sets some default values. 
public City()
{
    percentAdults = 0.5;
    percentChildren = 0.3;
    percentElders = 0.2;
    
    
    }

/*The central method of the class. Takes a parameter of number of days (how much time to pass),
* sets all tracker variables to 0 (since we only want to track the values of a single time period),
* then runs a loop to increase the values of the various demographics based on their growth and death rates,
* and the loop runs once per day. Then the method assigns new values to the tracking variables
* and finally assign the new values from the double variables to the int variables.
* We still store all the values as doubles so as not to lose any decimals, but displayed values are int.
*/
public void passTime(int numberOfDays){
    deadOldMen = 0;
    deadOldWomen = 0;
    deadMen = 0;
    deadWomen = 0;
    deadBoys = 0;
    deadGirls = 0;
    newOldMen = 0;
    newOldWomen = 0;
    newMen = 0;
    newWomen = 0;
    newBoys = 0;
    newGirls = 0;
    
    //The loop multiplies the current population with the mortality rate and aging/birth rate, then divides by number of days per year to get daily growth.
    //
    for (int i = numberOfDays; i > 0; i--){
        
    double oldMenDeath = ((doubleNumberOldMen * elderMortality) / daysPerYear);
    double oldWomenDeath = ((doubleNumberOldWomen * elderMortality) / daysPerYear);
    double menDeath = ((doubleNumberMen * adultMortality) / daysPerYear);
    double womenDeath = ((doubleNumberWomen * adultMortality) / daysPerYear);
    double boysDeath = ((doubleNumberBoys * childMortality) / daysPerYear);
    double girlsDeath = ((doubleNumberGirls * childMortality) / daysPerYear);
    double menAging = ((doubleNumberMen * adultsAging)  / daysPerYear);
    double womenAging = ((doubleNumberWomen * adultsAging)  / daysPerYear);
    double boysAging = ((doubleNumberBoys * childrenAging)  / daysPerYear);
    double girlsAging = ((doubleNumberGirls * childrenAging)  / daysPerYear);
    double boysBorn = (((((doubleNumberMen + doubleNumberWomen) * birthRate) / 2) * percentMale)  / daysPerYear);
    double girlsBorn = (((((doubleNumberMen + doubleNumberWomen) * birthRate) / 2) * percentFemale)  / daysPerYear);
    
    doubleNumberOldMen = (doubleNumberOldMen + menAging - oldMenDeath);
    doubleNumberOldWomen = (doubleNumberOldWomen + womenAging - oldWomenDeath);
    doubleNumberMen = (doubleNumberMen + boysAging - menDeath - menAging);
    doubleNumberWomen = (doubleNumberWomen + girlsAging - womenDeath - womenAging); 
    doubleNumberBoys = (doubleNumberBoys + boysBorn - boysDeath - boysAging);  
    doubleNumberGirls = (doubleNumberGirls + girlsBorn - girlsDeath - girlsAging); 
    
    
    deadOldMen = deadOldMen + oldMenDeath;
    deadOldWomen = deadOldWomen + oldWomenDeath;
    deadMen = deadMen + menDeath;
    deadWomen = deadWomen + womenDeath;
    deadBoys = deadBoys + boysDeath;
    deadGirls = deadGirls + girlsDeath;
    newOldMen = newOldMen + menAging;
    newOldWomen = newOldWomen + womenAging;
    newMen = newMen + boysAging;
    newWomen = newWomen + girlsAging;
    newBoys = newBoys + boysBorn;
    newGirls = newGirls + girlsBorn;
    
    
    }
    //Sets the display variables (int) with the values from double variable
    numberOldMen = (int)doubleNumberOldMen;
    numberOldWomen = (int)doubleNumberOldWomen;
    numberMen = (int)doubleNumberMen;
    numberWomen = (int)doubleNumberWomen;
    numberBoys = (int)doubleNumberBoys;
    numberGirls = (int)doubleNumberGirls;
    
    totalPopulation = (doubleNumberOldMen + doubleNumberOldWomen + doubleNumberMen + doubleNumberWomen + doubleNumberBoys + doubleNumberGirls);
    totalDeath = (int)deadOldMen + (int)deadOldWomen + (int)deadMen + (int)deadWomen + (int)deadBoys + (int)deadGirls;
    totalGrowth = (int)newBoys + (int)newGirls;
    
}

//Sets the initial values
public void initialCitySize(){

doubleNumberOldMen = ((totalPopulation * percentElders) * percentMale);
doubleNumberOldWomen = ((totalPopulation * percentElders) * percentFemale);
doubleNumberMen = ((totalPopulation * percentAdults) * percentMale);
doubleNumberWomen = ((totalPopulation * percentAdults) * percentFemale);    
doubleNumberBoys = ((totalPopulation * percentChildren) * percentMale);  
doubleNumberGirls = ((totalPopulation * percentChildren) * percentFemale);       

numberOldMen = (int)doubleNumberOldMen;
numberOldWomen = (int)doubleNumberOldWomen;
numberMen = (int)doubleNumberMen;
numberWomen =(int)doubleNumberWomen;
numberBoys = (int)doubleNumberBoys;
numberGirls = (int)doubleNumberGirls;
totalPopulation = (numberOldMen + numberOldWomen + numberMen + numberWomen + numberBoys + numberGirls);


}

//With this method we can adjust the mortality rates
public void setMortality(double adult, double elder, double child){
    elderMortality = elder;
    adultMortality = adult;
    childMortality = child;    
}

//With this method we can adjust the growthrates
public void setPopulationGrowthRates(double adult, double elder, double child){
    
    adultsAging = elder;
    childrenAging = adult;
    birthRate = child;
    
}
//With this method we can adjust the wealth rates
public void setWealthPercentages(double wealthy, double middle, double poor)
{
    percentWealthy = wealthy;
    percentMiddleClass = middle;
    percentPoor = poor;
}

//Getters and setters for initial population and city name
public String getCityName(){
    return cityName;
}
public void setCityName(String name){
    cityName = name;
}

public int getPop(){
    return (int)totalPopulation;
}
public void setPop(double pop){
    totalPopulation = pop;
    
}
    //Getters for the population variables
    public int getNumberOldMen() {
        return numberOldMen;
    }

    public int getNumberOldWomen() {
        return numberOldWomen;
    }

    public int getNumberMen() {
        return numberMen;
    }

    public int getNumberWomen() {
        return numberWomen;
    }

    public int getNumberBoys() {
        return numberBoys;
    }

    public int getNumberGirls() {
        return numberGirls;
    }

    public int getDeadOldMen() {
        return (int)deadOldMen;
    }

    public int getDeadOldWomen() {
        return (int)deadOldWomen;
    }

    public int getDeadMen() {
        return (int)deadMen;
    }

    public int getDeadWomen() {
        return (int)deadWomen;
    }

    public int getDeadBoys() {
        return (int)deadBoys;
    }

    public int getDeadGirls() {
        return (int)deadGirls;
    }

    public int getNewOldMen() {
        return (int)newOldMen;
    }

    public int getNewOldWomen() {
        return (int)newOldWomen;
    }

    public int getNewMen() {
        return (int)newMen;
    }

    public int getNewWomen() {
        return (int)newWomen;
    }

    public int getNewBoys() {
        return (int)newBoys;
    }

    public int getNewGirls() {
        return (int)newGirls;
    }

    public int getTotalDeath() {
        return totalDeath;
    }

    public int getTotalGrowth() {
        return totalGrowth;
    }



}
