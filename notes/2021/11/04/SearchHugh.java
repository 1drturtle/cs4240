import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class SearchHugh
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.err.println("Invalid arguments provided");
            System.exit(1);
        }

        Path file = Path.of("hughJass.txt");
        String search = args[0];

        try (
            BufferedReader reader = Files.newBufferedReader(file);
            BufferedWriter writer = Files.newBufferedWriter(Path.of("output.txt"));
            ) 
        {
            reader.lines()
                  .filter(x -> x.contains(search))
                  .forEach(x -> {
                    try {
                        writer.write(x + "\n");
                    } catch (IOException e) {
                        System.err.println("IOException while writing to output.");
                        System.exit(1);
                    }
                });
        } catch (IOException e) {
            System.err.println("IO Exception");
            System.exit(1);
        }

    }   
}
