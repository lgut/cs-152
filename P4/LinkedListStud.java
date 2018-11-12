import java.util.ArrayList;
/**
 * Write a description of class LinkedListStud here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedListStud
{
    // instance variables - replace the example below with your own
    private Node list;

    /**
     * Constructor for objects of class LinkedListStud
     */
    public LinkedListStud()
    {
        // initialise instance variables
        list = null;
    }

    /**
     * Returns reference to head of the list
     * @return  the head of the list
     */
    public Node getList()
    {
        return list;
    }
    
    /**
     * Checks to see if the list is empty
     * @return true or false
     */
    public boolean isEmpty()
    {
        if (list == null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Appends students to head of the list
     * @param   s Student object to be appended to the front
     */
    public void addFront(Student s)
    {
        Node head = new Node(s);

        if (isEmpty())
        {
            list = head;
        }
        else
        {
            head.next = list;
            list = head;
        }
    }
    
    /**
     * Appends student to end of the list
     * @param   s The student object to be appended to the end of the list
     */
    public void addTail(Student s)
    {
        Node tail = new Node(s);
        if(isEmpty())
        {
            list = tail;
        }
        else
        {
            Node curr = list;
            boolean found = false;
            while(!found)
            {
                if (curr.next == null)
                {
                    curr.next = tail;
                    found = true;
                }
                else
                {
                    curr = curr.next;
                }
            }
        }
    }
    
    /**
     * Prints string representation for each student in the list on a new line to standard output
     */
    public void printLinkedList()
    {
        if (!isEmpty())
        {
            Node curr = list;
            do
            {
                System.out.println(curr.data);
                curr = curr.next;
            } while (curr != null);
        }
    }
    
    /**
     * Finds the student with the best GPA
     * @return  Student object with the best GPA
     */
    public Student bestStudent()
    {
        if(!isEmpty())
        {   
            Node best = list;
            Node next = list.next;
            while(next != null)
            {
                if (best.data.getGPA() < next.data.getGPA())
                {
                    best = next;
                }
                next = next.next;
            }
            return best.data;
        }
        else
            return null;
    }
    
    /**
     * Creates an ArrayList containing all honor students
     * @return An ArrayList of Student objects
     */
    public ArrayList<Student> honorsStudents()
    {
        if(!isEmpty())
        {
            ArrayList<Student> ls = new ArrayList();
            Node curr = list;
            while(curr != null)
            {
                if (curr.data.isHonors())
                {
                    ls.add(curr.data);
                }
                curr = curr.next;
            }
            return ls;
        }
        else
            return new ArrayList();
    }
    
    /**
     * Recursively prints string representation for each student in the list on a new line to standard output
     * @param   first The starting point in a linked list from which to iterate from
     */
    public void printListRec(Node first)
    {
        if (first != null)
        {
            System.out.println(first.data);
            printListRec(first.next);
        }
    }
    
    /**
     * Recursively search for the worst GPA in the list
     * @param   first The starting point in a linked list from which to iterate from
     * @return  The lowest GPA in the list
     */
    public double worstGpaRec(Node first)
    {
        if (first != null)
        {
            double gpa = first.data.getGPA();
            if (gpa <= worstGpaRec(first.next))
            {
                return gpa;
            }
            else
            {
                return worstGpaRec(first.next);
            }
        }
        else
            // if null the list has reached the end
            // and smallest value is in a previous stack
            // that value should be less than 100
            return 100;
    }
    
    /**
     * Recusively creates an ArrayList of all honors students
     * @param   first The starting point in a linked list from which to iterate from
     * @return  An ArrayList of Student objects
     */
    public ArrayList<Student> honorsStudentsRec(Node first)
    {
        if (first != null)
        {
            ArrayList<Student> ls = new ArrayList();
            if (first.data.isHonors())
            { 
                ls.add(first.data); 
            }
            ls.addAll(honorsStudentsRec(first.next));
            return ls;
        }
        else
        {
            return new ArrayList();
        }
    }
    
    /**
     * Struct-like inner class representing list items
     */
    private class Node
    {
        public Student data;
        public Node next;
        /**
         * Constructor for objects of class Node
         */
        public Node(Student s)
        {
            data = s;
            next = null;
        }
    }

}