package cs05;

public class HeapArea {

    private int heapSize;
    private final String[] heapArea = new String[heapSize];

    public HeapArea(int heapSize) {
        this.heapSize = heapSize;
    }
}
