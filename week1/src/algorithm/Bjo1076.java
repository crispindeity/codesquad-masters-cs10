package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bjo1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        long firstValue = Resistance.getValue(buf.readLine());
        long secondsValue = Resistance.getValue(buf.readLine());
        long product = Resistance.getProduct(buf.readLine());

        System.out.println((firstValue * 10 + secondsValue) * product);
    }

    public enum Resistance {
        BLACK("black", 0, 1),
        BROWN("brown", 1, 10),
        RED("red", 2, 100),
        ORANGE("orange", 3, 1000),
        YELLOW("yellow", 4, 10000),
        GREEN("green", 5, 100000),
        BLUE("blue", 6, 1000000),
        VIOLET("violet", 7, 10000000),
        GREY("grey", 8, 100000000),
        WHITE("white", 9, 1000000000);

        private final String color;
        private final long value;
        private final long product;

        Resistance(String color, long value, long product) {
            this.color = color;
            this.value = value;
            this.product = product;
        }

        private boolean isSameColor(String color) {
            return this.color.equals(color);
        }

        public static long getValue(String color) {
            for (var v : Resistance.values()) {
                if (v.isSameColor(color)) {
                    return v.value;
                }
            }
            throw new IllegalArgumentException();
        }

        public static long getProduct(String color) {
            for (var v : Resistance.values()) {
                if (v.isSameColor(color)) {
                    return v.product;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}