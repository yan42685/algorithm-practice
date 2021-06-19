package temp;

import algorithm.common.Trie;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<>();
        trie.insert("abc", 1);
        trie.insert("hahah", 2);
        trie.insert("abcde", 3);
        trie.keySet();
    }
}
