public abstract class Person
{
    private String lastName;
    private String firstName;
    private final String ID;

    public Person(String firstName, String lastName, String ID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getID()
    {
        return ID;
    }
}
