package tenth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-07-06 17:44
 */
public class ReplaceWordsSolution {

    public String replaceWords2(List<String> dict, String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        String dictWord;
        boolean isStartWith;
        for (int i = 0; i < words.length; i++) {
            isStartWith = false;

            for (int j = 0; j < dict.size(); j++) {
                dictWord = dict.get(j);
                if (words[i].startsWith(dictWord)) {
                    builder.append(dictWord + " ");
                    isStartWith = true;
                    break;
                }
            }
            if (!isStartWith) {
                builder.append(words[i] + " ");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }


    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = buildTrie(dict);
        StringBuilder sb = new StringBuilder();
        String[] str = sentence.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            sb.append(findRoot(str[i], trie));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public Trie buildTrie(List<String> dict) {
        Trie trie = new Trie();
        for (int i = 0; i < dict.size(); i++) {
            String tmp = dict.get(i);
            trie.add(tmp);
        }
        return trie;
    }

    public String findRoot(String s, Trie trie) {
        Node cur = trie.root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (cur.map.get(c) == null) {
                return s;
            } else {
                cur = cur.map.get(c);
                if (cur.isWord) {
                    return sb.toString();
                }
            }
        }
        return s;
    }

    class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.map.get(c) == null) {
                    cur.map.put(c, new Node());
                }
                cur = cur.map.get(c);
            }
            cur.isWord = true;
        }
        public boolean contanins(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.map.get(c) == null) {
                    return false;
                }
                cur = cur.map.get(c);
            }
            return cur.isWord;
        }
    }


    class Node {
        public boolean isWord;
        public HashMap<Character, Node> map;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.map = new HashMap<>();
        }
        public Node() {
            this(false);
        }
    }


    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("a");
        dict.add("aaa");
        dict.add("aa");
        dict.add("aaaa");
        String sentence = "aaaa aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        ReplaceWordsSolution solution = new ReplaceWordsSolution();
        solution.replaceWords(dict, sentence);
        System.out.println(sentence);
    }
}




