package algorithm.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    @Test
    public void testDelete() {
        Trie<Integer> trie = new Trie<>();
        assertTrue(trie.insert("abcde", 1));
        assertFalse(trie.delete("abc"));
        assertFalse(trie.containsKey("abc"));
        assertNull(trie.get("abc"));

        assertTrue(trie.insert("abc", 2));
        assertEquals(trie.get("abcde"), 1);
        assertEquals(trie.get("abc"), 2);

        trie.delete("abc");
        assertFalse(trie.containsKey("abc"));
        assertEquals(trie.get("abcde"), 1);

        trie.insert("abc", 2);
        trie.delete("abcde");
        assertFalse(trie.containsKey("abcde"));
        trie.insert("abc", 2);
        assertEquals(trie.get("abc"), 2);

    }

    @Test
    public void testKeySet() {
        Trie<Integer> trie = new Trie<>();
        trie.insert("abc", 1);
        trie.insert("hahah", 2);
        trie.insert("abcde", 3);
        assertEquals(trie.get("abc"), 1);
        assertEquals(trie.get("hahah"), 2);
        assertEquals(trie.get("abcde"), 3);
        assertEquals(trie.keySet().size(), 3);
        assertTrue(trie.keySet().contains("abc"));
        assertTrue(trie.keySet().contains("hahah"));
        assertTrue(trie.keySet().contains("abcde"));
    }

}

