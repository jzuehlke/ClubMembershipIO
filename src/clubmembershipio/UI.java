package clubmembershipio;
import java.util.Scanner;
/**
 *
 * @author Jake Zuehlke
 */
public class UI 
{
    //scanner and char validation fields
    private Scanner kb = new Scanner(System.in);
    private String validChar = "";

    //UI main menu
    public UI(Roster theRoster)
    {
        //loop while exit is not chosen
        while(!validChar.equals("e"))
        {
            //menu header and options
            System.out.print("\n_____________________________________________\n"
                + "\nStudent Club Membership Database\n"
                + "\na. Add\nb. Delete\nc. Edit\nd. List\ne. Exit\n"
                + "\nAction: ");
            validChar = kb.nextLine().toLowerCase();
            
            //switch on input, call appropriate methods
            switch(validChar)
            {
                case "a": addMember(theRoster);
                    break;
                case "b": deleteMember(theRoster);
                    break;
                case "c": editMember(theRoster);
                    break;
                case "d": listMembers(theRoster);
                    break;
                default: break;
            }
        }
    }
    
    //UI add menu
    public void addMember(Roster theRoster)
    {
        //instantiate Student class object
        Student newStudent = new Student();
        
        //output header, save inputs to Student class object
        System.out.print("\n_________________________________________________\n"
            + "\nStudent Club Membership Database"
            + "\nAdd\n"
            + "\nName: ");
        newStudent.setName(kb.nextLine());
        System.out.print("\nEmail: ");
        newStudent.setEmail(kb.nextLine());
        
        //add record to roster list
        theRoster.addStudent(newStudent);
        
        //hit enter to return to menu
        System.out.print("\nHit enter to return to menu: ");
        kb.nextLine();
    }
    
    //UI delete menu
    public void deleteMember(Roster theRoster)
    {
        //header
        System.out.println("\n_______________________________________________\n"
            + "\nStudent Club Membership Database"
            + "\nDelete\n");
        
        //display names from roster list
        System.out.println(theRoster.getRosterNames());
        
        //if there is nothing to delete, guide back to menu
        if(!theRoster.getRosterNames().equals(""))
        {
            //prompt user for an integer, delete from roster
            System.out.print("\nWhich student do you want to delete?: ");
            int deleteChoice = kb.nextInt();
            
            //clear scanner
            kb.nextLine();
            
            //check to see if user entered a valid element number
            if(deleteChoice <= theRoster.getRosterSize()
                && deleteChoice > 0)
            {
                theRoster.deleteStudent(deleteChoice);
            }
        }
        
        //hit enter to return to menu
        System.out.print("\nHit enter to return to menu: ");
        kb.nextLine();
    }
    
    //UI edit menu
    public void editMember(Roster theRoster)
    {
        //header
        System.out.println("\n_______________________________________________\n"
            + "\nStudent Club Membership Database"
            + "\nEdit\n");
        
        //loop through roster arraylist for selection output
        System.out.println(theRoster.getRosterNames());
        
        //if there is nothing to edit, guide back to menu
        if(!theRoster.getRosterNames().equals(""))
        {
            //prompt for an integer, pull up that student's info for editing
            System.out.print("Which student do you want to edit?: ");
            int studentNumber = kb.nextInt();
            
            //clear Scanner
            kb.nextLine();
        
            //check to see if user entered a valid element number
            if(studentNumber <= theRoster.getRosterSize()
                && studentNumber > 0)
            {
                //prompt to change name, allow changes if Y is chosen
                System.out.print("\nChange name? (Y/N): ");
                String changeName = kb.nextLine().toUpperCase();
                if(changeName.equals("Y"))
                {
                    System.out.print("\nNew name: ");
                    String newName = kb.nextLine();
                    theRoster.setStudentName(studentNumber, newName);
                }

                //prompt to change email, allow changes if Y is chosen
                System.out.print("\nChange email? (Y/N): ");
                String changeEmail = kb.nextLine().toUpperCase();
                if(changeEmail.equals("Y"))
                {
                    System.out.print("\nNew email: ");
                    String newEmail = kb.nextLine();
                    theRoster.setStudentEmail(studentNumber, newEmail);
                }
            }
        }
        
        //hit enter to return to menu
        System.out.print("\nHit enter to return to menu: ");
        kb.nextLine();
    }
    
    //UI list menu
    public void listMembers(Roster theRoster)
    {
        //header
        System.out.println("\n_______________________________________________\n"
            + "\nStudent Club Membership Database"
            + "\nList\n"
            + "\nName\t\t\t\tEmail"
            + "\n----\t\t\t\t-----\n");
        
        //output roster list
        System.out.println(theRoster.getRosterList());
        
        //hit enter to return to menu
        System.out.print("\nHit enter to return to menu: ");
        kb.nextLine();
    }
}