Luis Gutierrez

CS 152

Project 3

## Movies.java

```java
//********************************************************************
//  Movies.java       Author: Lewis/Loftus
//
//  Demonstrates the use of an array of objects.
// Modified By: Luis Gutierrez
//********************************************************************

public class Movies
{
    //-----------------------------------------------------------------
    //  Creates a DVDCollection object and adds some DVDs to it. Prints
    //  reports on the status of the collection.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        DVDCollection movies = new DVDCollection();

        movies.addDVD("The Godfather", "Francis Ford Coppala", 1972, 24.95, true);
        movies.addDVD("District 9", "Neill Blomkamp", 2009, 19.95, false);
        movies.addDVD("Iron Man", "Jon Favreau", 2008, 15.95, false);
        movies.addDVD("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
        movies.addDVD("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);

        System.out.println(movies);

        movies.addDVD("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
        movies.addDVD("Casablanca", "Michael Curtiz", 1942, 19.95, false);

        // Movies added by Luis Gutierrez
        movies.addDVD("Logan", "James Mangold", 2017, 9.99, true);
        movies.addDVD("Venom", "Ruben Fleischer", 2018, 12.99, false);
        movies.addDVD("Black Klansman","Spike Lee", 2018, 12.99, true);
        System.out.println(movies);
        
        // successful test
        String director = "James Mangold";
        int index = movies.searchForDVD(director);
        if (index > -1)
        {
            DVD d = movies.getDVD(index);
            // Formated this way because I have a small screen
            System.out.println(
                "Movie by director " + director + " -> "+ d.toString()
            );
        } 
        else
        {
            System.out.println(
                "Movie by director "+ director+ " not found"
            );
        }
        
        // unsuccessful test
        director = "Bob Saget";
        index = movies.searchForDVD(director);
        if (index > -1)
        {
            // Formated this way because I have a small screen
            DVD d = movies.getDVD(index);
            // Formated this way because I have a small screen
            System.out.println(
                "Movie by director " + director + " -> "+ d.toString()
            );
        } 
        else
        {
            System.out.println(
                "Movie by director "+ director+ " not found"
            );
        }
    }
}
```

## DVDCollection.java

```java
//********************************************************************
//  DVDCollection.java       Author: Lewis/Loftus
//
//  Represents a collection of DVD movies.
// Modified by: Luis Gutierrez
//********************************************************************

import java.text.NumberFormat;

public class DVDCollection
{
    private DVD[] collection;
    private int count;
    private double totalCost;

    //-----------------------------------------------------------------
    //  Constructor: Creates an initially empty collection.
    //-----------------------------------------------------------------
    public DVDCollection()
    {
        collection = new DVD[100];
        count = 0;
        totalCost = 0.0;
    }

    //----------------------------------------------------------------
    // Finds out what index a DVD object AUGHT to be at in the collection based on its director value
    // ------------------------------------------------------------------

    private int binSearch(String director)
    {
        int middleIndex = count/2;
        int bound = 0;
        
        try
        { bound = director.compareToIgnoreCase(collection[middleIndex].getDirector()); }
        catch(NullPointerException e)
        { bound = 0; }
        finally
        {
            if (collection[0] == null)
            {
                return 0;
            }
            else if (bound == 0)
            {
                // if directors are the same 
                return middleIndex;
            }
            else
            {
                int i = 0;

                if (bound > 0)
                {
                    i = middleIndex;
                }

                while(i<count && director.compareToIgnoreCase(collection[i].getDirector()) > 0)
                {
                    i++;
                }

                return i;
            }
        }
    }

    //-----------------------------------------------------------------
    //  Adds a DVD to the collection, increasing the size of the
    //  collection array if necessary.
    // Modified by: Luis Gutierrez
    //-----------------------------------------------------------------
    public void addDVD(String title, String director, int year,
    double cost, boolean bluRay)
    {
        if (count == collection.length){increaseSize();}
        DVD d = new DVD(title, director, year, cost, bluRay);
        int insertLocation = binSearch(director);

        if (count == 0)
        {
            collection[0] = d;
        }
        else
        {
            for (int i = count; i >= insertLocation; i-- )
            {
                collection[i + 1] = collection[i];
            }
            collection[insertLocation] = d;
        }

        count++;
        totalCost += cost;

    }
    
    public int searchForDVD(String director)
    {   
        int possibleIndex = binSearch(director);
        if (director.compareToIgnoreCase(collection[possibleIndex].getDirector()) == 0)
        {
            return possibleIndex;
        }
        else
        {
            return -1;
        }
    }
    
    public DVD getDVD(int index)
    {
        return collection[index];
    }
    
    //-----------------------------------------------------------------
    //  Returns a report describing the DVD collection.
    //-----------------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        report += "My DVD Collection\n\n";

        report += "Number of DVDs: " + count + "\n";
        report += "Total cost: " + fmt.format(totalCost) + "\n";
        report += "Average cost: " + fmt.format(totalCost/count);

        report += "\n\nDVD List:\n\n";

        for (int dvd = 0; dvd < count; dvd++)
            report += collection[dvd].toString() + "\n";

        return report;
    }

    //-----------------------------------------------------------------
    //  Increases the capacity of the collection by creating a
    //  larger array and copying the existing collection into it.
    //-----------------------------------------------------------------
    private void increaseSize()
    {
        DVD[] temp = new DVD[collection.length * 2];

        for (int dvd = 0; dvd < collection.length; dvd++)
            temp[dvd] = collection[dvd];

        collection = temp;
    }
}
```

## DVD.java

```java
//********************************************************************
//  DVD.java       Author: Lewis/Loftus
//
//  Represents a DVD video disc.
//  Modified by: Luis Gutierrez
//********************************************************************

import java.text.NumberFormat;

public class DVD
{
    private String title, director;
    private int year;
    private double cost;
    private boolean bluRay;

    //-----------------------------------------------------------------
    //  Creates a new DVD with the specified information.
    //-----------------------------------------------------------------
    public DVD(String title, String director, int year, double cost,
    boolean bluRay)
    {
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
        this.bluRay = bluRay;
    }

    //-----------------------------------------------------------------
    //  Returns a string description of this DVD.
    //-----------------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String description;

        description = fmt.format(cost) + "\t" + year + "\t";
        description += title + "\t" + director;

        if (bluRay)
            description += "\t" + "Blu-Ray";

        return description;
    }

    public String getDirector()
    {
        return this.director;
    }
}
```

## Console Output

![](/home/luis/Projects/CCSU/CS 152/P3/Screenshot from 2018-10-23 23-42-56.png)

## UML Diagram

![](/home/luis/Projects/CCSU/CS 152/P3/P3 UML.png)