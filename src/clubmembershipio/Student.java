package clubmembershipio;
/**
 *
 * @author Jake Zuehlke
 */
public class Student 
{
    //fields
    private String name;
    private String email;

    //accessors
    public String getName() 
    {
        return name;
    }
    public String getEmail() 
    {
        return email;
    }

    //mutators
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    //override toString for file IO
    @Override
    public String toString() 
    {
        return name + "," + email;
    }
}
