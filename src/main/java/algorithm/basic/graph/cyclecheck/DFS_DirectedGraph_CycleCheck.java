package algorithm.basic.graph.cyclecheck;

import java.util.LinkedList;
import java.util.List;

// 有向图DFS环检测
class DFS_DirectedGraph_CycleCheck {
    private boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 用邻接表构建图并进行初始化
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }
        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        hasCycle = false;

        // dfs遍历整个图
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, path, visited, i);
            }
            if (hasCycle) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer>[] graph, boolean[] path, boolean[] visited, int curr) {
        if (hasCycle) {
            return;
        }
        path[curr] = true;
        visited[curr] = true;
        for (int next : graph[curr]) {
            if (path[next]) {
                hasCycle = true;
                return;
            }
            if (visited[next]) {
                continue;
            }
            dfs(graph, path, visited, next);
        }
        path[curr] = false;
    }
}
