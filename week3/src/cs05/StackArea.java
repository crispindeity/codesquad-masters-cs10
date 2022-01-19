package cs05;

public class StackArea {

    private int stackSize;
    private final String[] stackArea = new String[stackSize];

    public StackArea(int stackSize) {
        this.stackSize = stackSize;
    }
}
