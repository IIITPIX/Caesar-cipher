package ua.com.javarush.belmeha.module1;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Validate {

    public static String validatePath(Scanner in, PrintStream out, String message) {

        out.println(message);
        String fileName = in.nextLine();

        try {
            Path filePath = Path.of(fileName);
            if (Files.isDirectory(filePath)) {
                System.err.println("Введённый путь - директория! Нужен путь к файлу!!!");
                System.exit(0);
            } else if (!Files.isRegularFile(filePath)) {
                System.err.println("Введённый путь не коректный");
                System.exit(0);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Что-то пошло не так " + e);
            System.exit(0);
        }

        return fileName;
    }

    public static boolean isItDig(String dig) {

        try {
            Integer.parseInt(dig);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Вы ввели не цифру!");
            System.exit(0);
            return false;
        }

    }
}
