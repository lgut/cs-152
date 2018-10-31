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