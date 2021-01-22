package algorithm.leetcodefirstround;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (n <= 3) {
            return result;
        }
        // 获取所有的因子
        List<Integer> factors = new LinkedList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i * i != n) {
                    factors.add(n / i);
                }
            }
        }
        if (factors.isEmpty()) {
            return result;
        }
        // 让因子递增, 方便后续剪枝
        Collections.sort(factors);
        backtrack(0, n, factors, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int start, int target, List<Integer> factors, List<Integer> path, List<List<Integer>> result) {
        if (target == 1) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < factors.size(); i++) {
            if (target < factors.get(i)) {
                break;
            }
            if (target % factors.get(i) != 0) {
                continue;
            }
            path.add(factors.get(i));
            backtrack(i, target / factors.get(i), factors, path, result);
            path.remove(path.size() - 1);
        }
    }
}
