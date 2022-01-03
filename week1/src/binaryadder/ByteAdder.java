package binaryadder;

public class ByteAdder {

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        HalfAdder halfAdder = new HalfAdder();
        FullAdder fullAdder = new FullAdder();
        boolean[] answer = new boolean[9];

        boolean sum = halfAdder.halfAdder(byteA[0], byteB[0])[1];
        answer[0] = sum;
        boolean carry = halfAdder.halfAdder(byteA[0], byteB[0])[0];

        halfAdder.halfAdder(byteA[0], byteB[0]);

        for (int i = 1; i < byteA.length; i++) {
            sum = fullAdder.fullAdder(byteA[i], byteB[i], carry)[1];
            answer[i] = sum;
            carry = fullAdder.fullAdder(byteA[i], byteB[i], carry)[0];
        }
        answer[answer.length - 1] = carry;
        return answer;
    }
}