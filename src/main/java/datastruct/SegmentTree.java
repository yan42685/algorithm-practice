package datastruct;

/**
 * @author alexyan
 * @date 1/12/2020 21:58
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    /**
     * 预先确定线段树的长度
     */
    public SegmentTree(E[] array, Merger<E> merger) {
        if (array == null) {
            throw new IllegalArgumentException("传入数组不能为空");
        }
        this.merger = merger;
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        tree = (E[]) new Object[array.length * 4];
        buildSegmentTree(0, 0, array.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int size() {
        return data.length;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Illegal range");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
        if (queryL > mid) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

}
