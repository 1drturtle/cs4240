import java.util.ArrayList;

public class Student extends Person
{

    private double grade;
    private ArrayList<String> classList;

    public Student(String firstName, String lastName, String ID)
    {
        super(firstName, lastName, ID);
    }

    public double getGrade() {
        return grade;
    }

    public ArrayList<String> getClassList() {
        return classList;
    }
    
}
