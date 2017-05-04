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
private double adultMortality = 0.05;
private double childMortality = 0.1;

private double adultsAging = 0.1;
private double childrenAging = 0.3;
private double birthRate = 0.4;

private double percentFemale = 0.505;
private double percentMale = 0.495;

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

//Constructor takes 2 parameters and sets some default values
public City(String cityName, double totalPop)
{
    this.cityName = cityName;
    percentAdults = 0.5;
    percentChildren = 0.3;
    percentElders = 0.2;    
    totalPopulation = totalPop;
    }

/*The central method of the class. Takes a parameter of number of days (how much time to pass),
* sets all tracker variables to 0 (since we only want to track the values of a single time period),
* then runs a loop to increase the values of the various demographics based on their growth and death rates,
* and the loop runs once per day. Then the method assigns new values to the tracking variables
* and finally assign the new values from the double variables to the int variables
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
    
    
    deadOldMen = oldMenDeath;
    deadOldWomen = oldWomenDeath;
    deadMen = menDeath;
    deadWomen = womenDeath;
    deadBoys = boysDeath;
    deadGirls = girlsDeath;
    newOldMen = menAging;
    newOldWomen = womenAging;
    newMen = boysAging;
    newWomen = girlsAging;
    newBoys = boysBorn;
    newGirls = girlsBorn;
    
    }
    
    numberOldMen = (int)doubleNumberOldMen;
    numberOldWomen = (int)doubleNumberOldWomen;
    numberMen = (int)doubleNumberMen;
    numberWomen = (int)doubleNumberWomen;
    numberBoys = (int)doubleNumberBoys;
    numberGirls = (int)doubleNumberGirls;
    
    totalPopulation = (doubleNumberOldMen + doubleNumberOldWomen + doubleNumberMen + doubleNumberWomen + doubleNumberBoys + doubleNumberGirls);
    /*double populationGrowth;        
    populationGrowth = ((totalPopulation * populationGrowthRate) / 365) * numberOfDays;
    totalPopulation = totalPopulation + populationGrowth;
    System.out.println("Population after "+ numberOfDays +" days:");
    getCityInfo();*/
    /*System.out.println("boysBorn " + boysBorn);
    System.out.println("girlsBorn  "+ girlsBorn);
    System.out.println("menAging  "+ menAging);
    System.out.println("womenAging  "+ womenAging);
    System.out.println("boysAging  "+ boysAging);
    System.out.println("girlsAging  "+ girlsAging);
    System.out.println("");
    System.out.println("");
    System.out.println("oldMenDeath  "+ oldMenDeath);
    System.out.println("oldWomenDeath  "+ oldWomenDeath);
    System.out.println("womenDeath  " + womenDeath);
    System.out.println("menDeath  " + menDeath);
    System.out.println("boysDeath  " + boysDeath);
    System.out.println("girlsDeath  " + girlsDeath);
    System.out.println("");
    System.out.println("");*/
    
    
    
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

System.out.println("Initial number of old men: " + numberOldMen);
System.out.println("Initial number of old women: " + numberOldWomen);
System.out.println("Initial number of men: " + numberMen);
System.out.println("Initial number of women: " + numberWomen);
System.out.println("Initial number of boys: " + numberBoys);
System.out.println("Initial number of girls: " + numberGirls);
System.out.println("Initial total population: " + totalPopulation);

}
   //This method prints the various demographic values
public void getCityInfo()
{
    System.out.println("Old Men: " + numberOldMen);
    System.out.println("Old women: " + numberOldWomen);
    System.out.println("Men: " + numberMen);
    System.out.println("Women: " + numberWomen);
    System.out.println("Boys: " + numberBoys);
    System.out.println("Girls: " + numberGirls);
    System.out.println("Total number of people: " + totalPopulation);
    /*System.out.println("Wealthy people: " + (int)(totalPopulation * percentWealthy));
    System.out.println("Middle class people: " + (int)(totalPopulation * percentMiddleClass));
    System.out.println("Poor people: " + (int)(totalPopulation * percentPoor));*/
    
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
public String getCityName(){
    return cityName;
}

}
