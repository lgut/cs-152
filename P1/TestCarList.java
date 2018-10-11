
/**
 * Write a description of class TestCarList here.
 *
 * @author (Luis Gutierrez)
 * @version (08/29/2018)
 */
import java.io.*;
import java.util.ArrayList;
public class TestCarList
{
    public static void main(String[] args) throws IOException{
        File file = new File("inData.txt");
        CarList cars = new CarList(file);

        cars.printList();
        System.out.println();
        cars.printExpensiveCars();
        System.out.println();
        
        Car cheapestCar = cars.cheapestCar();
        System.out.println("\nCheapest Car:\n" + cheapestCar.toString());
        System.out.println();
        
        String make = "toyota";
        int makeCount = cars.countCarsWithMake(make);
        System.out.println(String.format("Number of %1ss: %2s", make, makeCount ));
        System.out.println();
        
        ArrayList<Car> antiques = cars.antiqueCarList();
        System.out.println("Antique Cars");
        for(Car car : antiques){
            System.out.println(car.toString());
        }
    }
}
