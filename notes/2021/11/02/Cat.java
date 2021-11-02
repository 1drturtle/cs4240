import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

public class Cat
{
    public static boolean lineTest(String line)
    {
        return line.startsWith("W");
    }
    public static void main(String[] args)
    {
        Path p = Path.of(args[0]);
        
        try(BufferedReader reader = Files.newBufferedReader(p))
        {

            reader.lines()
             .filter(Cat::lineTest)
             .forEach(System.out::println);

        } catch (IOException e) 
        {
            System.err.println(e);
        }
    }
}
