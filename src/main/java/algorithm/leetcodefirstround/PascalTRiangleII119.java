package algorithm.leetcodefirstround;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: alexyan
 * @date: 5/28/2019 00:25
 * @description:
 */
public class PascalTRiangleII119 {
    /**
     * j循环逆序是为了前一次set不影响后一次set
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j-1) + row.get(j));
            }
        }
        return row;
    }
}
