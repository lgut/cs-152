
/**
 * Write a description of class TestList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestList
{
    public static void main(String[] args)
    {
        LinkedListStud ll = new LinkedListStud();
        
        ll.addFront(new Student("Adams", 3.9, 2));
        ll.addFront(new Student("Jones",2.7,29));
        ll.addFront(new Student("Marcus",4,55));
        
        ll.addTail(new Student("Smith",3.1,20));
        ll.addTail(new Student("Lee",3.6,38));
        ll.addTail(new Student("Janus", 4, 28));
        
        System.out.println("ITERATIVE METHOD TESTS\n-------------------------");
        if (ll.isEmpty())
        {
            System.out.println("List is empty");
        }
        else
        {
            System.out.println("List is not empty");
        }
        System.out.println("\tList Contents:");
        ll.printLinkedList();
        String bestStudentMsg = String.format("Best Student -> %s", ll.bestStudent());
        System.out.println(bestStudentMsg);
        System.out.println("\tHonor Role");
        for(Student s : ll.honorsStudents())
        {
            System.out.println(s);
        }
        System.out.println("RECURSIVE METHOD TEST\n----------------------------");
        ll.printListRec(ll.getList());
        String worstGpaMsg = String.format("Worst GPA in list: %.2f", ll.worstGpaRec(ll.getList()));
        System.out.println(worstGpaMsg);
        System.out.println("\tHonor Role");
        for(Student s : ll.honorsStudentsRec(ll.getList()))
        {
            System.out.println(s);
        }
    }
}
