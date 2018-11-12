
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student implements Comparable<Student>
{
    // instance variables - replace the example below with your own
    private int age;
    private double gpa;
    private String lastName;

    /**
     * Constructor for objects of class Student
     */
    public Student(String s, double g, int a)
    {
        // initialise instance variables
        lastName = s;
        gpa = g;
        age = a;
    }
    
    /**
     * Get the GPA of this Student
     * @return  The GPA of the student
     */
    public double getGPA()
    {
        return gpa;
    }
    
    /**
     * Determine whether this student is an honor student
     * @return  true or false
     */
    public boolean isHonors()
    {
        if (gpa >= 3.5)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Create a string representation of this student
     * @return  A string
     */
    public String toString()
    {
        String rep = "Last Name: %s\tAge: %d\tGPA: %.2f";
        return String.format(rep, lastName, age, gpa);
    }
    
    /**
     * Compares this student's GPA against another student
     * @return The integers -1, 0, or 1 if this student's GPA is less than, equal to, or greater than the other students, respectively
     */
    @Override
    public int compareTo(Student s){
        if (gpa < s.getGPA())
        {
            return -1;
        }
        else if (gpa > s.getGPA())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
