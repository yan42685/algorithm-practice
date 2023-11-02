package trash.homework.designpattern.lab4.two;

public class DataOperationAdapter implements DataOperation {
    @Override
    public void sort(int[] data) {
        QuickSort.quicksort(data);
    }

    @Override
    public int search(int[] data, int target) {
        return BinarySearch.binarySearch(data, target);
    }
}
