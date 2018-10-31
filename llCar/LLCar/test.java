
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    public static void main(String[] args)
    {
        LL myList = new LL();
        myList.addHead(new Car("1", "Ford", "Model T", 100000, 1902));
        myList.addHead(new Car("a23ht", "Subaru", "Legacy", 6000, 2002));
        myList.addHead(new Car("bthuh", "Toyota", "Corolla", 13000, 2014));
        
        System.out.println(myList.toStringRec(myList.getList()));
    }
}
