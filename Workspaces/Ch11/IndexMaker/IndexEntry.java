import java.util.ArrayList;

public class IndexEntry {
	private String word;
    private ArrayList<Integer> numsList;
 	
     public IndexEntry(String s)
    {
       word = s.toUpperCase(); //Makes the word capital in the constructor itself
       numsList = new ArrayList<Integer>(); //Default ArrayList of size 10
    }
     public void add(int num)
    {
       if(!numsList.contains(num)) //If the numsList has not the number
          numsList.add(num); //Add it
    }
 	
     public String getWord()
    {
       return word; //Simply returns the word in the private data field
    }
 	
     public String toString()
    {
       String s = word + " "; //Instantiates return String with the current word
       for(Integer i : numsList) //For every integer in the number ArrayList
          s += i + ", "; //Add it and add a ,\s
       s = s.substring(0, s.length()-2); //Remove the extraneous ,\s
       return s; //Return the String representation of the Index
    }
 }

