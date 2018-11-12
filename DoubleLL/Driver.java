
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args)
    {
        DoubleEndedLL myList = new DoubleEndedLL();
        myList.addTail(new Car(2012, "Toyota", "Camry"));
        myList.addTail(new Car(2017, "Ford", "Focus"));
        myList.addTail(new Car(1955, "Buick", "ccc"));
    }
}
