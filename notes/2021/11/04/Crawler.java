import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Crawler
{

    /**
     * Lists a directory to stout.
     * @param toSearch The directory to search.
     * @param fileType The file ending to filter by (don't include the ".")
     */
    private static void listDirectory(Path toSearch, String fileType)
    {
        try
        {
            Files.list(toSearch)
                 .filter(x -> x.toString().endsWith("." + fileType))
                 .forEach(System.out::println);
        } catch (IOException e)
        {
            throw new RuntimeException(String.format("IO Exception for directory %s", toSearch.toString()));
        }
    }

    public static void main(String[] args)
    {

        if (args.length < 2)
        {
            System.err.println("Invalid usage.");
            System.err.println("Usage: java Crawler directory fileExtension");
            System.exit(1);
        }



        Path p = Path.of(args[0]);

        if (!Files.isDirectory(p))
        {
            System.err.println("Provided path must exist and be a directory.");
            System.exit(1);
        }

        String fileType = args[1];

        listDirectory(p, fileType);
        
    }
}
