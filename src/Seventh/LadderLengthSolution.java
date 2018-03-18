package Seventh;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

   Only one letter can be changed at a time
   Each intermediate word must exist in the dictionary
   For example,

   Given:
   start ="hit"
   end ="cog"
   dict =["hot","dot","dog","lot","log"]

   As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
   return its length5.

   Note:

   Return 0 if there is no such transformation sequence.
   All words have the same length.
   All words contain only lowercase alphabetic characters.
 *
 * @date 2018/3/18 下午3:59
 */
public class LadderLengthSolution {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.length() == 1 && end.length() == 1)
            return 2;
        if (isDiffOne(start, end))
            return 2;
        Queue<String> queue1 = new LinkedBlockingDeque<>();
        Queue<String> queue2 = new LinkedBlockingDeque<>();
        int count = 2;
        queue2.add(start);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<String> tempList = new ArrayList<>();
            if (count % 2 == 0) {

                while (!queue2.isEmpty()) {
                    start = queue2.poll();
                    for (String s : dict) {
                        if (isDiffOne(start, s)) {
                            queue1.add(s);
                            tempList.add(s);
                            if (isDiffOne(s, end)) {
                                return count + 1;
                            }
                            if (dict.isEmpty())
                                return 0;
                        }
                    }
                    dict.removeAll(tempList);
                }

                count++;
            } else {
                while (!queue1.isEmpty()) {
                    start = queue1.poll();
                    for (String s : dict) {

                        if (isDiffOne(start, s)) {
                            tempList.add(s);
                            queue2.add(s);

                            if (isDiffOne(s, end)) {
                                return count + 1;
                            }
                            if (dict.isEmpty())
                                return 0;
                        }
                    }
                    dict.removeAll(tempList);
                }
                count++;
            }

        }
        return 0;
    }

    public boolean isDiffOne(String string1, String string2) {
        int count = 0;
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }

    public static void main(String[] args) {
        LadderLengthSolution ladderLengthSolution = new LadderLengthSolution();
        HashSet<String> stringSet = new HashSet<>();
        // ["hot","dog","cog","pot","dot"]
        stringSet.add("hot");
        stringSet.add("dog");
        stringSet.add("cog");
        stringSet.add("pot");
        stringSet.add("dot");
        System.out.println(ladderLengthSolution.ladderLength("hot", "dog", stringSet));

    }

}
