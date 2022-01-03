package binaryadder;

public class HalfAdder {

    private boolean sum(boolean bitA, boolean bitB) {
        LogicGate logicGate = new LogicGate();
        return logicGate.xorGate(bitA, bitB);
    }

    private boolean carry(boolean bitA, boolean bitB) {
        LogicGate logicGate = new LogicGate();
        return logicGate.andGate(bitA, bitB);
    }

    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[]{carry(bitA, bitB), sum(bitA, bitB)};
    }
}