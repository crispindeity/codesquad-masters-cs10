package cs05;

public class Scenario {

    private final int STACK_SIZE = 1024;
    private final int HEAP_SIZE = 1024;

    public void scenarioStart() {
        Memory memory = new Memory();
        int baseAddress = memory.init(STACK_SIZE, HEAP_SIZE);
        System.out.println("BaseAddress: " + "0x" + baseAddress);
        

    }
}

