package First;

import java.util.Iterator;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package First
 * @Description: 使用 map reduce 来计算单词频率
 * @date 2017/6/6 22:09
 */
public class WordCount {

    class OutputCollector<K, V> {
        public void collect(K key, V value){

        }
    }

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] arr = value.split(" ");
            for (int i=0; i<arr.length; i++) {
                output.collect(arr[i], 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while(values.hasNext()) {
                sum += values.next().intValue();
            }
            output.collect(key, sum);
        }
    }


}
