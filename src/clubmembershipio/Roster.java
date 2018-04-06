package clubmembershipio;
import java.util.ArrayList;
/**
 *
 * @author Jake Zuehlke
 */
public class Roster 
{
    //field
    ArrayList<Student> roster = new ArrayList<>();
    
    //mutators
    public void addStudent(Student s)
    {
        roster.add(s);
    }
    public void deleteStudent(int i)
    {
        roster.remove(i - 1);
    }
    public void setStudentName(int i, String name)
    {
        roster.get(i - 1).setName(name);
    }
    public void setStudentEmail(int i, String email)
    {
        roster.get(i - 1).setEmail(email);
    }
    
    //accessors
    public int getRosterSize()
    {
        return roster.size();
    }
    public String getRosterNames()
    {
        String list = "";
        
        for(int i = 0; i < roster.size(); i++)
        {
            list += ((i + 1) + ". " + roster.get(i).getName() + "\n");
        }
        return list;
    }
    public String getRosterList()
    {
        String list = "";
        
        //loop through roster for output, depending on size of name
        for(int i = 0; i < roster.size(); i++)
        {
            if(roster.get(i).getName().length() < 8)
            {
                list += roster.get(i).getName()
                    + "\t\t\t\t" + roster.get(i).getEmail() + "\n";
            }
            else if(roster.get(i).getName().length() < 16)
            {
                list += roster.get(i).getName()
                    + "\t\t\t" + roster.get(i).getEmail() + "\n";
            }
            else if(roster.get(i).getName().length() < 24)
            {
                list += roster.get(i).getName()
                    + "\t\t" + roster.get(i).getEmail() + "\n";
            }
            else
            {
                list += roster.get(i).getName()
                    + "\t" + roster.get(i).getEmail() + "\n";
            }
        }
        return list;
    }
}
