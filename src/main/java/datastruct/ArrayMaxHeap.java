package datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author alexyan
 * @date 1/11/2020 21:41
 */
public class ArrayMaxHeap<E extends Comparable<E>> implements MaxHeap<E> {
    private ArrayList<E> data;

    public ArrayMaxHeap() {
        data = new ArrayList<>();
    }

    public ArrayMaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    /**
     * convert E[] to MaxHeap
     */
    public ArrayMaxHeap(E[] array) {
        data = new ArrayList<>(Arrays.asList(array));
        for (int i = parent(data.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E element) {
        data.add(element);
        siftUp(data.size() - 1);
    }

    @Override
    public E extractMax() {
        E result = findMax();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return result;
    }

    @Override
    public E findMax() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素并放入一个元素
     */
    @Override
    public E replace(E element) {
        E result = findMax();
        data.set(0, element);
        siftDown(0);
        return result;
    }

    private void siftUp(int i) {
        while (i != 0 && (data.get(i).compareTo(data.get(parent(i)))) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.size()) {
            int j = leftChild(i);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }


    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new ArrayMaxHeap<>(testData);
        } else {
            maxHeap = new ArrayMaxHeap<>(testData.length);
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            try {
                arr[i] = maxHeap.extractMax();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        final int n = 1000000;

        Random random = new Random();
        Integer[] testData1 = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData1[i] = random.nextInt(Integer.MAX_VALUE);
        }

        Integer[] testData2 = Arrays.copyOf(testData1, n);

        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData2, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
