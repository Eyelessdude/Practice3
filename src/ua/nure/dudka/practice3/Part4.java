package ua.nure.dudka.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    private static final int MAX_DIGIT = 9;
    private static final int HEX_TAIL = 2;

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        StringBuilder resultBuilder = new StringBuilder();

        digest.update(input.getBytes());
        byte[] hash = digest.digest();

        for (byte currentByte : hash) {
            if (currentByte >= 0 && currentByte <= MAX_DIGIT) {
                resultBuilder.append("0").append(Integer.toHexString(currentByte).toUpperCase());
            } else if (currentByte > MAX_DIGIT) {
                resultBuilder.append(Integer.toHexString(currentByte).toUpperCase());
            } else {
                String hexHash = Integer.toHexString(currentByte).toUpperCase();
                resultBuilder.append(hexHash.substring(hexHash.length() - HEX_TAIL));
            }
        }

        return String.valueOf(resultBuilder);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pass = "password";
        System.out.println(hash(pass, "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
        System.out.println();
    }
}
