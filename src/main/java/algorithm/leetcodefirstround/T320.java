package algorithm.leetcodefirstround;

import java.util.LinkedList;
import java.util.List;

public class T320 {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new LinkedList<>();
        backtrack(0, 0, word, "", result);
        return result;
    }

    private void backtrack(int index, int count, String word, String line, List<String> result) {
        if (index == word.length()) {
            if (count != 0) {
                line += count;
            }
            result.add(line);
            return;
        }
        backtrack(index + 1, count + 1, word, line, result);

        if (count != 0) {
            line += count;
        }
        line += word.charAt(index);
        backtrack(index + 1, 0, word, line, result);
    }
}
