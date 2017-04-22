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
public class City {

    
private String cityName;
private double totalPopulation;
private double percentElders;
private double percentAdults;
private double percentChildren;

private int numberOldMen;
private int numberOldWomen;
private int numberMen;
private int numberWomen;
private int numberBoys;
private int numberGirls;

private double doubleNumberOldMen;
private double doubleNumberOldWomen;
private double doubleNumberMen;
private double doubleNumberWomen;    
private double doubleNumberBoys;  
private double doubleNumberGirls;   
        
        
private double elderMortality = 0.2;
private double adultMortality = 0.05;
private double childMortality = 0.1;

private double adultsAging = 0.1;
private double childrenAging = 0.25;
private double birthRate = 0.35;

private double percentFemale = 0.51;
private double percentMale = 0.49;

private double percentWealthy = 0.03;
private double percentMiddleClass = 0.27;
private double percentPoor = 0.7;

private int deadOldMen;
private int deadOldWomen;
private int deadMen;
private int deadWomen;
private int deadBoys;
private int deadGirls;

public City(String cityName, double totalPop)
{
    this.cityName = cityName;
    percentAdults = 0.5;
    percentChildren = 0.3;
    percentElders = 0.2;    
    totalPopulation = totalPop;
    }


public void passTime(double numberOfDays){
    
    double oldMenDeath = (((doubleNumberOldMen * elderMortality) / 365) * numberOfDays);
    double oldWomenDeath = (((doubleNumberOldWomen * elderMortality) / 365) * numberOfDays);
    double menDeath = (((doubleNumberMen * adultMortality) / 365) * numberOfDays);
    double womenDeath = (((doubleNumberWomen * adultMortality) / 365) * numberOfDays);
    double boysDeath = (((doubleNumberBoys * childMortality) / 365) * numberOfDays);
    double girlsDeath = (((doubleNumberGirls * childMortality) / 365) * numberOfDays);    
    double menAging = ((doubleNumberMen * adultsAging)  / 365) * numberOfDays;    
    double womenAging = ((doubleNumberWomen * adultsAging)  / 365) * numberOfDays;    
    double boysAging = ((doubleNumberBoys * childrenAging)  / 365) * numberOfDays;    
    double girlsAging = ((doubleNumberGirls * childrenAging)  / 365) * numberOfDays;
    double boysBorn = (((((doubleNumberMen + doubleNumberWomen) * birthRate) / 2) * percentMale)  / 365) * numberOfDays;    
    double girlsBorn = (((((doubleNumberMen + doubleNumberWomen) * birthRate) / 2) * percentFemale)  / 365) * numberOfDays;    
    
    
    
    
    
    numberOldMen = (int)(doubleNumberOldMen + menAging - oldMenDeath);
    numberOldWomen = (int)(doubleNumberOldWomen + womenAging - oldWomenDeath);
    numberMen = (int)(doubleNumberMen + boysAging - menDeath - menAging);
    numberWomen = (int)(doubleNumberWomen + girlsAging - womenDeath - womenAging);
    numberBoys = (int)(doubleNumberBoys + boysBorn - boysDeath - boysAging);
    numberGirls = (int)(doubleNumberGirls + girlsBorn - girlsDeath - girlsAging);
    
    totalPopulation = (int)(numberOldMen + numberOldWomen + numberMen + numberWomen + numberBoys + numberGirls);
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


public void initialCitySize(){

    

numberOldMen = (int)((totalPopulation * percentElders) * percentMale);
numberOldWomen = (int)((totalPopulation * percentElders) * percentFemale);
numberMen = (int)((totalPopulation * percentAdults) * percentMale);
numberWomen =(int)((totalPopulation * percentAdults) * percentFemale);
numberBoys = (int)((totalPopulation * percentChildren) * percentMale);
numberGirls = (int)((totalPopulation * percentChildren) * percentFemale);
totalPopulation = (int)(numberOldMen + numberOldWomen + numberMen + numberWomen + numberBoys + numberGirls);

System.out.println("Initial number of old men: " + numberOldMen);
System.out.println("Initial number of old women: " + numberOldWomen);
System.out.println("Initial number of men: " + numberMen);
System.out.println("Initial number of women: " + numberWomen);
System.out.println("Initial number of boys: " + numberBoys);
System.out.println("Initial number of girls: " + numberGirls);
System.out.println("Initial total population: " + totalPopulation);

}
   
public void getCityInfo()
{
    System.out.println("Old Men: " + numberOldMen);
    System.out.println("Old women: " + numberOldWomen);
    System.out.println("Men: " + numberMen);
    System.out.println("Women: " + numberWomen);
    System.out.println("Boys: " + numberBoys);
    System.out.println("Girls: " + numberGirls);
    System.out.println("Total number of people: " + (int)totalPopulation);
    /*System.out.println("Wealthy people: " + (int)(totalPopulation * percentWealthy));
    System.out.println("Middle class people: " + (int)(totalPopulation * percentMiddleClass));
    System.out.println("Poor people: " + (int)(totalPopulation * percentPoor));*/
    
}

public void setMortality(double adult, double elder, double child){
    elderMortality = elder;
    adultMortality = adult;
    childMortality = child;    
}
/*public void setPopulationGrowthRates(double growth){
    populationGrowthRate = growth;
}*/
public void setWealthPercentages(double wealthy, double middle, double poor)
{
    percentWealthy = wealthy;
    percentMiddleClass = middle;
    percentPoor = poor;
}

}
