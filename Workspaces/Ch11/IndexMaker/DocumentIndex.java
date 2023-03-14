import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
    public DocumentIndex()
   {
      super(); //Calls default constructor of ArrayList
   }
	
    public DocumentIndex(int size)
   {
      super(size); //Calls default constructor of ArrayList with argument size
   }
	
    public void addWord(String str, int num)
   {
      boolean found = false; //Set a boolean to false
      IndexEntry ie = new IndexEntry(str); //Instantiate a new IndexEntry object holding String str
      ie.add(num); //Add a number to the IndexEntry
      for(int i=0; i<this.size();i++) //For all the IndexEntries in this current object
         if(str.toUpperCase().equals(this.get(i).getWord())) //If the word is equal to the IndexEntry word
         {
            this.get(i).add(num); //Add the number to the IndexEntry
            found = true; //Set the boolean to true
         }
      if(found == false && size() > 0) //Ignore if the word was found
      {
         if(get(size()-1).getWord().compareTo(str.toUpperCase()) < 0) //Compares str to the last entry
         {
            add(ie); //DocumentIndex adds the IndexEntry
            return; //Ends the method
         } 
         for(int i= 0; i<this.size();i++) //For all IndexEntries in this DocumentIndex
         {
            if(this.get(i).getWord().compareTo(str.toUpperCase()) > 0) //Selectively sorts the list
            {
               add(i, ie); //Adds the IndexEntry to the object in the alphabetic position
               return; //Quit the method to lessen runtime if possible
            }
         }
      }
      else if(found == false) //If and only if boolean found is false
         add(ie); //Add the IndexEntry to the current DocumentIndex
   }
	
    public void addAllWords(String str, int num)
   {
    	String[] strArray = str.split("\\W+"); //Splits the array except for blank lines
      for(String s : strArray) //For every String sorted
         if(!s.trim().equals("")) //If it is not an empty line
            addWord(s, num); //Add this to the num position
   }
	
   
}