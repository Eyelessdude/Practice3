package ua.nure.dudka.practice3;

public class Part3 {
    private static final int MAX_LENGTH = 2;

    public static String convert(String input) {
        String[] toUpperCaseWords;
        String[] defaultWords;
        String result = input;

        toUpperCaseWords = input.replaceAll("\\p{P}", " ").split("\\s+");
        defaultWords = input.replaceAll("\\p{P}", " ").split("\\s+");

        for (int i = 0; i < toUpperCaseWords.length; i++) {
            if (toUpperCaseWords[i].length() > MAX_LENGTH) {
                toUpperCaseWords[i] = Character.toUpperCase(toUpperCaseWords[i].charAt(0))
                        + toUpperCaseWords[i].substring(1);
            }
        }

        for (int i = 0; i < defaultWords.length; i++) {
            result = result.replaceAll(defaultWords[i], toUpperCaseWords[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        String input = Util.readFile("part3.txt");

        System.out.println(convert(input));
        System.out.println();
    }
}
