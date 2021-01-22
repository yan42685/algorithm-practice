package datastruct;

/**
 * @author alexyan
 * @date 1/12/2020 21:08
 */
public class UnionFind {
    private int[] rank;
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    public int size() {
        return parent.length;
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    public void unionElements(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return;
        }
        if (rank[aRoot] < rank[bRoot]) {
            parent[aRoot] = bRoot;
        } else if (rank[aRoot] > rank[bRoot]) {
            parent[bRoot] = aRoot;
        } else {
            parent[aRoot] = bRoot;
            rank[bRoot] += 1;
        }
    }

    private int find(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index is out of bound!");
        }
        if (index != parent[index]) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
