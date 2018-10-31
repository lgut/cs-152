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