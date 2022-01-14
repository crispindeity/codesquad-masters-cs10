package findarea;

import java.util.Scanner;

public class Input {

    public void init() {
        inputString();
    }

    public void inputString() {
        Scanner scan = new Scanner(System.in);
        DataSplit dataSplit = new DataSplit();
        while (true) {
            try {
                System.out.println("> 좌표를 입력하세요.");
                String input = scan.nextLine();
                if (input.length() < 6) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                dataSplit.splitInput(input);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}