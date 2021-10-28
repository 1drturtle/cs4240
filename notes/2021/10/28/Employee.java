public abstract class Employee extends Person
{
    private String title;

    public Employee(String firstName, String lastName, String ID, String title)
    {
        super(firstName, lastName, ID);
    }

    public String getTitle() {
        return title;
    }

    public abstract double computePay();

    @Override
    public String toString() {
        return String.format("Employee: %s %s %s (ID %s)", title, this.getFirstName(), this.getLastName());
    }
}
