package tenth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-09 11:13
 */



public class InvertedIndexSolution {

    abstract class OutputCollector<K, V> {
        abstract void collect(K key, V value);
        // Adds a key/value pair to the output buffer
    }
    class Document {
        public int id;
        public String content;
    }

    public static class Map {
        public void map(String _, Document value,
            OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);

            String[] words = value.content.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                output.collect(words[i], value.id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
            OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            int before = -1;
            int now;
            List<Integer> result = new ArrayList<>();
            while (values.hasNext()) {
                now = values.next();
                if (before != now) {
                    result.add(now);
                }
                before = now;
            }
            output.collect(key, result);
        }
    }

}
