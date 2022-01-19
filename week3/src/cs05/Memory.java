package cs05;

public class Memory {

    private final int BASE_ADDRESS = 1000;

    Type setType = new Type();

    public int init(int stackSize, int heapSize) {
        StackArea stackArea = new StackArea(stackSize);
        HeapArea heapArea = new HeapArea(heapSize);
        return BASE_ADDRESS;
    }


    public boolean setSize(String type, int length) {
        boolean success = setType.setTypeSize(type, length);
        return success;
    }

    public void malloc(Object type, int count) {

    }

    public void free(Object pointer) {

    }

    public void call(Object name, Object paramCount) {

    }

    public void returnFrom(Object name) {

    }

    public void usage() {

    }

    public void callstack() {

    }

    public void heapDump() {

    }

    public void garbageCollect() {

    }
}