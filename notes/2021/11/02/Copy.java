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

        try {
            Files.copy(input, output);
        } catch (IOException e) {
            System.err.println(e);
        }

        try
        (
            BufferedReader reader = Files.newBufferedReader(input);
            BufferedWriter writer = Files.newBufferedWriter(output);
        )
        {

            /* reader.lines().forEach(
                line ->
                {
                    try {
                        writer.write(line + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException("IO failed.");
                    }
                }
            ); */

            writer.write(Files.readString(input));

            System.out.printf("Copied %s to %s\n", input.toString(), output.toString());

        } catch (IOException e) 
        {
            System.err.println(e);
        }
    }
}
