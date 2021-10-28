public class SalariedEmployee extends Employee
{
    private double salary;

    public SalariedEmployee(String firstName, String lastName, String ID, String title, double salary)
    {
        super(firstName, lastName, ID, title);
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double computePay() {
        return salary / 52;
    }
}
