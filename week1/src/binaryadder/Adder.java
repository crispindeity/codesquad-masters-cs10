package binaryadder;

public class Adder {

    LogicGate logicGate;

    public Adder(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    private boolean sum(boolean bitA, boolean bitB) {
        return logicGate.xorGate(bitA, bitB);
    }

    private boolean carry(boolean bitA, boolean bitB) {
        return logicGate.andGate(bitA, bitB);
    }

    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[]{carry(bitA, bitB), sum(bitA, bitB)};
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carryBit) {
        boolean topHalfAdderCarry = halfAdder(carryBit, sum(bitA, bitB))[0];
        boolean fullAdderCarry = logicGate.orGate(topHalfAdderCarry, carry(bitA, bitB));
        boolean fullAdderSum = halfAdder(carryBit, sum(bitA, bitB))[1];
        return new boolean[]{fullAdderCarry, fullAdderSum};
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int byteLength = byteA.length > byteB.length ? byteA.length + 1 : byteB.length + 1;
        boolean[] answer = new boolean[byteLength];

        boolean sum = halfAdder(byteA[0], byteB[0])[1];
        answer[0] = sum;
        boolean carry = halfAdder(byteA[0], byteB[0])[0];

        for (int i = 1; i < byteLength; i++) {
            sum = fullAdder(byteA[i], byteB[i], carry)[1];
            answer[i] = sum;
            carry = fullAdder(byteA[i], byteB[i], carry)[0];
        }
        answer[answer.length - 1] = carry;
        return answer;
    }
}