package algorithm.common;

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

}

