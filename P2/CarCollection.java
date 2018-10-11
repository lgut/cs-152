
/**
 * A class with methods meant to recursively iterate over 
 * arrays of Car objects
 *
 * @author (Luis Gutierrez)
 * @version (10/03/18)
 */
public class CarCollection
{
    /**
     * Returns a string representation of all cars in an array
     *
     * @param  list  A list of car obects
     * @param len Length of list
     * @return    String
     */
    public static String toString(Car[] list, int len)
    {
        if (len > 0)
        {
            return list[len - 1].toString() + "\n" + toString(list, len - 1);
        }
        else
        {
            return "";
        }
    }
    
    /**
     * Returns the number of antique cars in thre list
     *
     * @param  list  A list of car obects
     * @param len Length of list
     * @return    int
     */
    public static int countAntique(Car[] list, int len)
    {
        if (len > 0)
        {
            if (list[len - 1].isAntique())
            {
                return 1 + countAntique(list, len - 1);
            }
            else
            {
                return countAntique(list, len - 1);
            }
        }else
        {
            return 0;
        }
    }
    
    /**
     * Prints all cars from the list that are expensive
     *
     * @param  list  A list of car obects
     * @param len Length of list
     */
    public static void printExpensiveCars(Car[] list, int len)
    {
        if(len > 0)
        {
            Car car = list[len - 1];
            printExpensiveCars(list, len - 1);
            if (car.isExpensive())
            {
                System.out.println(car.toString());
            }
        }
    }
    
    /**
     * Prints all cars from the list of a certain make
     *
     * @param  list  A list of car obects
     * @param len Length of list
     */
    public static void printCarsWithMake(Car[] list, int len, String make)
    {
        if(len > 0)
        {
            Car car = list[len - 1];
            printCarsWithMake(list, len - 1, make);
            if (car.getMake().compareToIgnoreCase(make) == 0)
            {
                System.out.println(car.toString());
            }
        }
    }
    
    public static Car cheapestCar(Car[] list, int len)
    {
        if (len > 0)
        {
            if (list[len - 1].getCost() < cheapestCar(list, len - 1).getCost()){
                return list[len - 1];
            }
            else
            {
                return cheapestCar(list,len - 1);
            }
        }
        else
        {
            return list[len];
        }
    }
}
