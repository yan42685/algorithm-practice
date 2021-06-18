package algorithm.common;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Node root = new Node();

    private static class Node {
        boolean isEnd = false;
        private final Map<Character, Node> map = new HashMap<>();
    }

    public void insert(String word) {
        Node pre = null;
        Node curr = root;
        for (char c : word.toCharArray()) {
            pre = curr;
            curr = curr.map.get(c);
            if (curr == null) {
                curr = new Node();
                pre.map.put(c, curr);
            }
        }
        curr.isEnd = true;
    }

    public boolean startsWith(String prefix) {
        Node lastNode = getLastMatchNode(prefix);
        return lastNode != null;
    }

    public boolean search(String word) {
        Node lastNode = getLastMatchNode(word);
        return lastNode != null && lastNode.isEnd;
    }

    /**
     * 如果word中的字符全部匹配，则返回最后一个匹配的Node，否则返回null
     */
    private Node getLastMatchNode(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.map.get(c);
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }
}
