
/**
 * Write a description of class DoubleEndedLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoubleEndedLL
{
    private Node first, last;
    /**
     * Constructor for objects of class DoubleEndedLL
     */
    public DoubleEndedLL()
    {
        first = null;
        last = null;
    }
    
    public void addTail(Car car)
    {
        Node n = new Node(car);
        if (first == null)
        {
            first = n;
            last = n;
        }
        else
        {
            last.next = n;
            last = n;
        }
    }

    public Car deleteHead()
    {
       Car temp = first.data;
       first = first.next;
       if (first == null)
       {
            last = null;
       }
       return temp;
    }

    public Car deleteNodeByReference()
    {
        // informal hw
    }
    
    public int countAntique()
    {
        int count = 0;
        Node current = first;
        while(current != null)
        {
            if (current.data.isAntique())
            {
                count++;
            }
            else
            {
                current = current.next;
            }
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
