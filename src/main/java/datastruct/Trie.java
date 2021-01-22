package datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexyan
 * @date 1/12/2020 21:27
 */
public class Trie {
    private static class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        private Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        private Node() {
            this(false);
        }
    }

    private int size;
    private Node root;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public void add(String word) {
        if (word == null || "".equals(word)) {
            throw new IllegalArgumentException("传入字符串为空!");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean isPrefix(String prefix) {
        if (prefix == null || "".equals(prefix)) {
            return false;
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
