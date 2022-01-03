package binaryadder;

public class FullAdder {

    private boolean sum(boolean bitA, boolean bitB, boolean bitC) {
        HalfAdder halfAdder = new HalfAdder();
        boolean halfAdderSum = halfAdder.halfAdder(bitA, bitB)[1];
        return halfAdder.halfAdder(bitC, halfAdderSum)[1];
    }

    private boolean carry(boolean bitA, boolean bitB, boolean bitC) {
        HalfAdder halfAdder = new HalfAdder();
        LogicGate logicGate = new LogicGate();
        boolean halfAdderSum = halfAdder.halfAdder(bitA, bitB)[1];
        boolean halfAdderCarry = halfAdder.halfAdder(bitA, bitB)[0];
        boolean fullAdderCarry = halfAdder.halfAdder(bitC, halfAdderSum)[0];
        return logicGate.orGate(fullAdderCarry, halfAdderCarry);
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean bitC) {
        return new boolean[]{carry(bitA, bitB, bitC), sum(bitA, bitB, bitC)};
    }
}