import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Regex
{
    public static String cleanWord(String word)
    {
        word = word.toLowerCase().strip().replaceAll("\\W", "").replaceAll("\\s", "");
        return word;
    }

    // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args)
    {
        // args[0] -> filename
        String file_name = args[0];
        Path file = Path.of(file_name);
        try
        (
            Stream<String> lines = Files.lines(file);
            BufferedWriter wr = Files.newBufferedWriter(Path.of("out/output_java_alpha.txt"));
            BufferedWriter wr2 = Files.newBufferedWriter(Path.of("out/output_java_num.txt"));
        )
        {
            List<String> words = lines.flatMap(line -> Stream.of(line.split("\\s+")))
                                      .collect(Collectors.toList());

            // Alphabetical
            TreeMap<String, Integer> word_map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

            for (String word : words) 
            {
                word = cleanWord(word);
                if (word.equals("")) continue;
                word_map.put(word, word_map.getOrDefault(word, 0) + 1);    
            }

            for (Map.Entry<String, Integer> x : word_map.entrySet()) 
            {
                wr.write(String.format("%s: %s\n", x.getKey(), x.getValue()));    
            }

            // Numerical?

            LinkedHashMap<String, Integer> sorted_word_map = sortByValue(word_map);

            // https://www.geeksforgeeks.org/how-to-iterate-linkedhashmap-in-reverse-order-in-java/
            List<String> keys = new ArrayList<>(sorted_word_map.keySet());

            Collections.reverse(keys);
            
            for (String x : keys) 
            {
                wr2.write(String.format("%s: %s\n", x, sorted_word_map.get(x)));    
            }


        } catch (IOException e) 
        {
            System.err.println(e);
        }
    }
}