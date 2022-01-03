package binaryadder;

public class LogicGate {

    public boolean andGate (boolean paramA, boolean paramB) {
        return paramA && paramB;
    }

    public boolean orGate (boolean paramA, boolean paramB) {
        return paramA || paramB;
    }

    public boolean nandGate (boolean paramA, boolean paramB) {
        return !(paramA && paramB);
    }

    public boolean xorGate (boolean paramA, boolean paramB) {
        if (paramA && paramB) {
            return false;
        }
        return paramA || paramB;
    }
}