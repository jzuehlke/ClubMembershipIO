package clubmembershipio;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Jake Zuehlke
 */
public class ClubMembershipIO 
{
    //Final Project: Student Club Membership Database
    public static void main(String[] args) throws IOException
    {
        //instantiate object of Roster ArrayList
        Roster theRoster = new Roster();
        
        //input a roster to fill the arraylist, if one exists
        inputRoster(theRoster);
        
        //instantiate object of UI, begin user interface
        UI theUI = new UI(theRoster);
        
        //output the updated arrayList to roster txt file
        outputRoster(theRoster);
    } 
    
    //input from file
    public static void inputRoster(Roster theRoster) throws IOException
    {
        //instantiate File object as the roster .txt file
        File rosterFile = new File("ClubMembershipRoster.txt");
        Scanner inputFile = new Scanner(rosterFile);
        
        //loop as long as there is info in the file
        while(inputFile.hasNext())
        {
            //get a line, and parse it into a 2-element array
            String line = inputFile.nextLine();
            String[] lineArray = line.split(",");
            
            //instantiate Student, add lineArray elements into it
            Student theStudent = new Student();
                theStudent.setName(lineArray[0]);
                theStudent.setEmail(lineArray[1]);
            
            //add theStudent to theRoster
            theRoster.roster.add(theStudent);
        }
    }
    
    //output to file
    public static void outputRoster(Roster theRoster) throws IOException
    {
        //instantiate PrintWriter object
        PrintWriter outputFile = new PrintWriter("ClubMembershipRoster.txt");
        
        //loop through arraylist, output each Student object using its toString
        for(int i = 0; i < theRoster.getRosterSize(); i++)
        {
            outputFile.println(theRoster.roster.get(i));
        }
        //close file
        outputFile.close();
        
        //output success message
        System.out.println("\nRoster Updated");
    }
}
