import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchHugh
{
    public static void main(String[] args)
    {
        // check for arguments
        if (args.length < 1)
        {
            System.err.println("Invalid arguments provided");
            System.exit(1);
        }

        // create path of the large words file
        Path file = Path.of("hughJass.txt");
        // get the search string from user-in
        String search = args[0];

        try (
            // create a reader for the file
            BufferedReader reader = Files.newBufferedReader(file);
            // create a writer to write the output
            BufferedWriter writer = Files.newBufferedWriter(Path.of("output.txt"));
            ) 
        {
            // create a stream
            reader.lines()
                  // filter each line using the search string
                  .filter(x -> x.contains(search))
                  // write each line to the writer (output.txt)
                  .forEach(x -> {
                    try {
                        writer.write(x + "\n");
                    } catch (IOException e) {
                        System.err.println("IOException while writing to output.");
                        System.exit(1);
                    }
                });
        } catch (IOException e)
        {
            System.err.println("IO Exception");
            System.exit(1);
        }

    }   
}
