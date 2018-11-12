
/**
 * Class representing a car and it's properties
 *
 * @author (Luis Gutierrez)
 * @version (08/30/2018)
 */
public class Car
{
    private String vin, make, model;
    private double cost;
    private int year;
    

    /**
     * Constructor for objects of class Car
     */
    public Car(
        int year, 
        String make, 
        String model 
        //double cost, 
        //int year
        )
    {
        this.year = year;
        this.make = make;
        this.model = model;
        //this.cost = cost;
        //this.year = year;
    }
    
    /**
     * Constructor for objects of class car
     * 
     * Assumes that array items are in the correct order
     * @param tokens - A String array containing strings that correspond to car properties
     */
    public Car(String[] tokens){
        this.vin = tokens[0];
        this.make = tokens[1];
        this.model = tokens[2];
        this.cost = Double.parseDouble(tokens[3]);
        this.year = Integer.parseInt(tokens[4]);
    }

    /**
     * Returns the car's cost
     * 
     * @return this.cost
     */
    public double getCost()
    {
        return this.cost;
    }
    
    /**
     * Returns this car's make
     * 
     * @return this.make
     */
    public String getMake(){
        return this.make;
    }
    
    /**
     * Returns true if cost of car is greater than $30,000
     */
    public boolean isExpensive(){
        return this.cost > (double) 30000;
    }
    
    /**
     * Returns true if car's model year is before 1968
     */
    public boolean isAntique(){
        return this.year < 1968;
    }
    
    public int getYear()
    {
        return this.year;
    }
    
    /**
     * Returns a string representation of this car
     * 
     * @return String
     */
    public String toString(){
        String template = "%s\t%s\t%s\t%s\t%s";
        
        return String.format(template,
            this.vin,
            this.make,
            this.model,
            this.cost,
            this.year
        );
        
    }
}
