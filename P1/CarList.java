
/**
 * Write a description of class CarList here.
 *
 * @author (Luis Gutierrez)
 * @version (08/29/2018)
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CarList
{
    private ArrayList<Car> list;

    /**
     * Constructor for objects of class CarList
     */
    public CarList(File file) throws IOException
    {
        try{
            this.list = new ArrayList<Car>();
            /*BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] tokens = st.split(" ");
                Car car = new Car(tokens);
                list.add(car);
            }*/
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String[] tokens = sc.nextLine().toString().split(" ");
                Car car = new Car(tokens);
                list.add(car);
            }

        }catch(FileNotFoundException e){
            System.out.println("File location specified cannot be read or does not exist");
            System.out.println(e);
        }
    }
    
    /**
     * Prints the heading shared by all
     * of CarList's print functions
     */
    private void printHeading(){
        System.out.println("Vin\t\tMake\tModel\tCost\tYear");
    }

    /**
     * Prints a list of all cars
     */
    public void printList()
    {
        System.out.println("All Cars");
        this.printHeading();
        for (Car car: list){
            System.out.println(car.toString());
        }

    }

    /**
     * Prints a list of expensive cars
     */
    public void printExpensiveCars(){
        System.out.println("Most Expensive Cars");
        this.printHeading();
        for (Car car: this.list){
            if (car.isExpensive()){
                System.out.println(car.toString());
            }
        }
    }
    
    /**
     * Returns the cheapest car from this list
     * 
     * @return car
     */
    public Car cheapestCar(){
        Car cheapestCar = this.list.get(0);
        for(Car car : this.list){
            if (car.getCost() < cheapestCar.getCost()){
                cheapestCar = car;
            }
        }
        return cheapestCar;
    }
    
    /**
     * Determines how many cars with a given make are in this list
     * 
     * @param String make - the make of car being queried for
     * @return int
     */
    public int countCarsWithMake(String make){
        int count = 0;
        for(Car car : this.list){
            if(car.getMake().compareToIgnoreCase(make) == 0){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Returns an ArrayList of all antique cars
     * 
     * @returns ArrayList<Car>
     */
    public ArrayList<Car> antiqueCarList(){
        ArrayList<Car> antiques = new ArrayList<Car>();
        
        for(Car car: this.list){
            if(car.isAntique()){
                antiques.add(car);
            }
        }
        return antiques;
    }
}
