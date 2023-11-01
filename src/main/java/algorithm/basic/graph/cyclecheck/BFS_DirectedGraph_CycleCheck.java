package algorithm.basic.graph.cyclecheck;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_DirectedGraph_CycleCheck {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] indegrees = new int[numCourses];
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            ++indegrees[pair[0]];
        }
        // 统计可以完成的课程数
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ++count;
            for (int next : graph[curr]) {
                --indegrees[next];
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;


    }
}
