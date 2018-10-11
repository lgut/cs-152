
/**
 * Class Flight describes flight
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flight
{
    // instance variables - replace the example below with your own
    private String airline, origin, destination, status;
    private int number;

    /**
     * Constructor for objects of class Flight
     */
    public Flight(){}
    public Flight(String airline, String origin, String destination, String status, int number)
    {
        // initialise instance variables
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.number = number;
    }

    /**
     * 
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getAirline()
    {
        // put your code here
        return this.airline;
    }
    public void setAirline(String airline)
    {
        this.airline = airline;
    }
    public String getOrigin(){
        return this.origin;
    }
    public void setOrigin(String org){
        this.origin = org;
    }
    public String getDestination(){
        return this.destination;
    }
    public void setDestination(String d)
    {   
        this.destination = d;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String s){
        this.status = s;
    }
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int n){
        this.number = n;
    }
    public String toString(){
        return airline + "\t" + origin + "\t" + destination + "\t" + status + "\t" + Integer.toString(number);
    }
}
