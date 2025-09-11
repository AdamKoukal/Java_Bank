package People;

public class Human
{
    private String UUID;

    private String FirstName;

    private String LastName;

    public Human(String UUID, String FirstName, String LastName)
    {
        this.UUID = UUID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getUUID()
    {
        return UUID;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public String getLastName()
    {
        return LastName;
    }
}
