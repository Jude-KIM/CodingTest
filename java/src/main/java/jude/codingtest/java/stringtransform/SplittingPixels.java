package jude.codingtest.java.stringtransform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplittingPixels {

    public static void main(String[] args) throws IOException {
        List<String> bytes = new ArrayList<>();
        bytes.add("101111010110011011100100");
        bytes.add("110000010101011111101111");
        bytes.add("100110101100111111101101");
        bytes.add("010111011010010110000011");
        bytes.add("000000001111111111111111");
        values.add(BLACK);
        values.add(WHITE);
        values.add(RED);
        values.add(GREEN);
        values.add(BLUE);
        System.out.println(closestColor(bytes).toString());
    }

    public static List<Color> values = new ArrayList<>(5);
    public static Color BLACK = new Color(0, 0, 0, "Black");
    public static Color WHITE = new Color(255, 255, 255, "White");
    public static Color RED = new Color(255, 0, 0, "Red");
    public static Color GREEN = new Color(0, 255, 0, "Green");
    public static Color BLUE = new Color(0, 0, 255, "Blue");

    public static List<String> closestColor(List<String> pixels) {
        // Write your code here
        List<Color> colors = new ArrayList<>(pixels.size());
        List<String> result = new ArrayList<>();
        for(String s : pixels) {
            Color color = getColor(s);
            colors.add(color);
//            result.add(color.toString());
        }

        for(Color color : colors) {
            result.add(calculate(color));
        }

        return result;
    }

    public static String calculate(Color color) {

        double result = Integer.MAX_VALUE;
        String name = "Ambiguous";
        for(Color target : values) {
            int red = color.red - target.red;
            int green = color.green - target.green;
            int blue = color.blue - target.blue;
            double value = Math.sqrt(red * red + green * green + blue * blue);
            if(result > value) {
                result = value;
                name = target.name;
            } else if(result == value) {
                name = "Ambiguous";
            }
        }

        return name;
    }

    public static Color getColor(String bits) {
        int red = Integer.parseInt(bits.substring(0, 8), 2);
        int green = Integer.parseInt(bits.substring(8, 16), 2);
        int blue = Integer.parseInt(bits.substring(16, 24), 2);
        return new Color(red, green, blue);
    }

    public static class Color {

        int red, green, blue;
        String name = "";
        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue= blue;
            this.name = "Ambiguous";
        }

        public Color(int red, int green, int blue, String name) {
            this.red = red;
            this.green = green;
            this.blue= blue;
            this.name = name;
        }
    }
}
