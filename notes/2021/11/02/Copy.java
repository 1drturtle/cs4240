import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Copy
{
    public static void main(String[] args)
    {
        Path input = Path.of(args[0]);
        Path output = Path.of(args[1]);
        
        try
        (
            BufferedReader reader = Files.newBufferedReader(input);
            BufferedWriter writer = Files.newBufferedWriter(output);
        )
        {
            reader.lines()
             .forEach(line -> {
                try {
                    writer.write(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
