package ninth;

import java.util.*;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-18 11:24
 */
public class TopKFrequentWordsSolution {

    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        Map<String, Integer> wordCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordCount.containsKey(words[i])) {
                count = wordCount.get(words[i]);
                count++;
                wordCount.put(words[i], count);
            } else {
                wordCount.put(words[i], 1);
            }
        }
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>();
        mapList.addAll(wordCount.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        String[] topK = new String[k];
        for (int i = 0; i < k; i++) {
            topK[i] = mapList.get(i).getKey();
        }
        return topK;
    }

    public static void main(String[] args) {

    }

}
