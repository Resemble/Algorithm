package tenth;

import java.util.HashMap;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: TODO！重点看，主要是想到了一种数据结构，哈哈。
 * @date 2019-06-23 09:59
 */
public class Trie {

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean hasWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

    }


    private TrieNode root;

    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        if (findNode(word) == null) {
            return false;
        } else if (findNode(word).hasWord) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        if (findNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode findNode(String word) {
        TrieNode cur = null;
        HashMap<Character, TrieNode> curChildren = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curChildren.containsKey(c)) {
                cur = curChildren.get(c);
            } else {
                return null;
            }
            curChildren = cur.children;
        }
        return cur;
    }

}
