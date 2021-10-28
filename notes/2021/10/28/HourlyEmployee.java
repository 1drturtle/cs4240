public class HourlyEmployee extends Employee
{
    private double hourlyRate;

    public HourlyEmployee(String firstName, String lastName, String ID, String title, double hourlyRate)
    {
        super(firstName, lastName, ID, title);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double computePay() {
        return hourlyRate * 40;
    }
}
