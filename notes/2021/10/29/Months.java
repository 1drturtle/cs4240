public class Months
{
    private final String[] names;

    public Months()
    {
        names = new String[]{"January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November", "December"};
    }

    public static void main(String[] args)
    {
        Months m = new Months();
        try
        {
            int month = Integer.parseInt(args[0]) - 1;
            System.out.printf("The month is %s\n", m.names[month]);
        } 
        catch (IndexOutOfBoundsException | NumberFormatException e)
        {
            System.err.println("Invalid input provided. Please enter a number 1-12");
        }
        finally 
        {
           System.out.println("Dying..."); 
        }
    }
}