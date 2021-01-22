package algorithm.leetcodefirstround;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: alexyan
 * @date: 5/27/2019 15:13
 * @description:
 */
public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int a = allRows.get(i - 1).get(j - 1);
                    int b = allRows.get(i - 1).get(j);
                    row.add(a + b);
                }
            }
            allRows.add(row);
        }
        return allRows;
    }
}

