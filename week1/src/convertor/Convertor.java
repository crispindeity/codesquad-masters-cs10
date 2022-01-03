package convertor;

public class Convertor {
    /**
     * TODO 2진법 자릿수 입력값에 따라 변동되게 만들어보자.
     */
    public boolean[] dec2bin(int decimal) {
        int numberOfDigits = 8;
        boolean[] answer = new boolean[numberOfDigits];
        int value = decimal;
        int count = 0;
        while (value != 1) {
            if (value % 2 == 0) {
                value /= 2;
                answer[count] = false;
                count++;
                continue;
            }
            value /= 2;
            answer[count] = true;
            count++;
        }
        answer[count] = true;
        return answer;
    }

    public int bin2dec(boolean[] bin) {
        int answer = 0;
        int squared = 2;
        if (bin[0]) {
            answer++;
        }
        for (int i = 1; i < bin.length; i++) {
            if (bin[i]) {
                answer += squared;
                squared *= 2;
                continue;
            }
            squared *= 2;
        }
        return answer;
    }
}