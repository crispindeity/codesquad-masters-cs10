package convertor;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public boolean[] dec2bin(int decimal) {
        List<Boolean> answer = new ArrayList<>();
        int value = decimal;
        while (value != 1) {
            if (value % 2 == 0) {
                value /= 2;
                answer.add(false);
                continue;
            }
            value /= 2;
            answer.add(true);
        }
        answer.add(true);
        return bitListToArr(answer);
    }

    private boolean[] bitListToArr(List<Boolean> answer) {
        boolean[] bitArr = new boolean[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            bitArr[i] = answer.get(i);
        }
        return bitArr;
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