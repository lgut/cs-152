import java.util.ArrayList;
/**
 * Write a description of class LL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LL
{
    // instance variables - replace the example below with your own
    private Node list;

    /**
     * Constructor for objects of class LL
     */
    public LL()
    {
        list = null;
    }
    
    public Node getList()
    {
        return list;
    }
    
    public int countAntique(Node first){
        if (list == null){
            return 0;
        }
        else if(first.data.isAntique())
        {
            return 1 + countAntique(first.next);
        }
        else
        {
            return countAntique(first.next);
        }
    }
    
    public void addHead(Car car){
        if (list != null){
            Node oldData = list;
            list = new Node(car);
            list.next = oldData;
        }else{
            list = new Node(car);
        }
    }
    
    public String toStringRec(Node first)
    {
        String res = "";
        if (first == null)
        {
            return "";
        }
        else
        {
            return first.data + toStringRec(first.next);
        }
    }
    /*
    public ArrayList<Car> newestCars()
    {
        ArrayList cars = new ArrayList<Car>();
        if (list == null)
        {
            return cars;
        }
        else
        {
            return
        }
    }*/
    
    public String getNewestCarRec(Node ls)
    {
        if (ls == null)
        {
            return "";
        }
        else if (ls.data.getYear() >= 2018 - 5)
        {
            return getNewestCarRec(ls.next) + ls.data;
        }
        else
        {
            return getNewestCarRec(ls.next);
        }
    }
    
    private class Node
    {
        public Car data;
        public Node next;
        
        public Node(Car car)
        {
            data = car;
            next = null;
        }
    }
    
}
