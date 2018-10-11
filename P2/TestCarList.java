import java.util.*;
import java.io.*;
/**
 * Write a description of class TestCarList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCarList
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("inData.txt");
        Car[] myCars = new Car[100];
        
        Scanner sc = new Scanner(file);
        int carCount = 0;
        while(sc.hasNextLine())
        {
            String[] tokens = sc.nextLine().toString().split(" ");
            myCars[carCount] = new Car(tokens);
            carCount++;
        }
        
        System.out.println("All Cars in the list");
        System.out.println(CarCollection.toString(myCars, carCount) + "\n");
        
        System.out.println("Number of antique cars:\t" + 
            CarCollection.countAntique(myCars, carCount));
            
        System.out.println("All expensive cars");
        CarCollection.printExpensiveCars(myCars, carCount);
        System.out.println();
        
        String make = "Subaru";
        System.out.println("All cars of make: " + make);
        CarCollection.printCarsWithMake(myCars, carCount, make);
        
        System.out.println("Cheapest Car:");
        System.out.println(CarCollection.cheapestCar(myCars, carCount));
    }
}
