package ua.nure.dudka.practice3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Part1 {
    private static Random randomPassword = new SecureRandom();
    private static final int START_BOUND = 1000;
    private static final int END_BOUND = 10000;

    public static String convert1(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(input);
        String[] userInfo;

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            userInfo = line.split(";");
            resultBuilder.append(userInfo[0]).append(" ==> ").append(userInfo[2]).append(System.lineSeparator());
        }
        scanner.close();

        return String.valueOf(resultBuilder);
    }

    public static String convert2(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(input);
        String[] userInfo;
        String[] user;

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            userInfo = line.split(";");
            user = userInfo[1].split(" ");
            resultBuilder.append(user[1]).append(" ").append(user[0]).append(" (email: ")
                    .append(userInfo[2]).append(")").append(System.lineSeparator());
        }
        scanner.close();

        return String.valueOf(resultBuilder);
    }

    public static String convert3(String input) {
        StringBuilder resultbuilder = new StringBuilder();
        List<String> userInfo = new ArrayList<>();
        List<String> domains = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        String domain;

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            domain = line.substring(line.indexOf('@') + 1);
            userInfo.add(line);
            if (!domains.contains(domain)) {
                domains.add(domain);
            }

        }

        for (String findDomain : domains) {
            resultbuilder.append(findDomain).append(" ==> ");
            for (String user : userInfo) {
                if (findDomain.equals(user.substring(user.indexOf('@') + 1))) {
                    resultbuilder.append(user.split(";")[0]).append(", ");
                }
            }
            resultbuilder.delete(resultbuilder.lastIndexOf(", "), resultbuilder.length());
            resultbuilder.append(System.lineSeparator());
        }

        scanner.close();
        return String.valueOf(resultbuilder);
    }

    public static String convert4(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(input);

        String line = scanner.nextLine();
        resultBuilder.append(line).append(";Password").append(System.lineSeparator());

        int password;

        while (scanner.hasNextLine()) {
            password = START_BOUND + randomPassword.nextInt(END_BOUND);
            line = scanner.nextLine();
            resultBuilder.append(line).append(";").append(password).append(System.lineSeparator());
        }
        scanner.close();

        return String.valueOf(resultBuilder);
    }

    public static void main(String[] args) {
        String input = Util.readFile("part1.txt");

        System.out.println(Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.println(Part1.convert4(input));
    }
}