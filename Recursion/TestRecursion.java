
/**
 * Write a description of class TestRecursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class TestRecursion
{
    public static void main(String[] args)
    {
        Recursion r = new Recursion();
        int testNumber = 400;
        System.out.println("Digit count: " + r.countDigits(testNumber));
        System.out.println("Odd Factorial: " + r.sumFirstNodd(testNumber) );
        r.convertToBase(testNumber, 2);
        int[] list = {8,1,2,3,3};
        System.out.println();
        System.out.println("Sum of list: "+ r.sumArray(list, list.length));
        System.out.println("Count of 3 in array");
        System.out.println(r.countItem(list, list.length, 3));
        System.out.println(r.largest(list, list.length));
        System.out.println(r.contains(list, list.length, 2000));
        
        System.out.println("Array search result");
        System.out.println(r.search(list, list.length, 7));
        
        Flight[] flights = {
            new Flight("Delta", "BDL", "LAX", "On Time", 217),
            new Flight("KLM", "SFO", "BDL", "Delayed", 555),
            new Flight("United", "ORD", "SFO", "Delayed", 756),
        };
        System.out.println("Flight test");
        System.out.println(r.searchF(flights, flights.length, "SFO").toString());  
        System.out.println("On time flights");
        r.printOnTime(flights, flights.length);
        
        /*System.out.println("Changing KLM to on time");
        for(Flight f : flights){
            if (f.getAirline().equalsIgnoreCase("klm")){
                f.setStatus("On Time");
                System.out.println(f.toString());
                break;
            }
        }*/
        System.out.println("Delayed flights");
        r.printDelayedSFO(flights, flights.length);
        
        int[] nums = new int[10];
        r.assignPowersOfTwo(nums, nums.length);
        for(int num: nums){
            System.out.print(Integer.toString(num) + "\t");
        }
        
        
    }
}
