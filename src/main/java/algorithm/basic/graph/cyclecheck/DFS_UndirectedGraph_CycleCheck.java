package algorithm.basic.graph.cyclecheck;

import java.util.LinkedList;
import java.util.List;

// 无向图DFS环检测, 这里不需要path数组与visited数组进行区分，考虑A-B-C  D-B-E  无向图在第一次访问B的时候必定会访问D和E， 而有向图不会
class DFS_UndirectedGraph_CycleCheck {
    private boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]); // 注意：无向图，需要添加双向边
            graph[pair[1]].add(pair[0]);
        }
        boolean[] visited = new boolean[numCourses];
        hasCycle = false;

        // dfs遍历整个图
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i, -1); // -1 表示开始节点没有父节点
            }
            if (hasCycle) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, int curr, int prev) {
        if (hasCycle) {
            return;
        }
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (visited[next]) {
                if (next == prev) {  // 无向图跳过相邻节点逆向边
                    continue;
                } else {
                    hasCycle = true;
                    return;
                }
            }
            dfs(graph, visited, next, curr);
        }
    }
}
