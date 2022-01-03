package binaryadder;

public class FullAdder {

    private boolean sum(boolean bitA, boolean bitB, boolean bitC) {
        HalfAdder halfAdder = new HalfAdder();
        boolean halfAdderSum = halfAdder.sum(bitA, bitB);
        return halfAdder.sum(bitC, halfAdderSum);
    }

    private boolean carry(boolean bitA, boolean bitB, boolean bitC) {
        HalfAdder halfAdder = new HalfAdder();
        LogicGate logicGate = new LogicGate();
        boolean halfAdderSum = halfAdder.sum(bitA, bitB);
        boolean halfAdderCarry = halfAdder.carry(bitA, bitB);
        boolean fullAdderCarry = halfAdder.carry(bitC, halfAdderSum);
        return logicGate.orGate(fullAdderCarry, halfAdderCarry);
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean bitC) {
        return new boolean[]{carry(bitA, bitB, bitC), sum(bitA, bitB, bitC)};
    }
}