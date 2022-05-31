package ua.com.javarush.belmeha.module1;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я',

            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',

            'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e',
            'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n',
            'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U',
            'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z',

            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ',

            '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static final int ALPHABET_SIZE = ALPHABET.size();

    public static void main(String[] args) {
        Dialog.greeting();
        Scanner scanner = new Scanner(System.in);
        String chooseDig = scanner.nextLine();
        Validate.isItDig(chooseDig);
        Dialog.selectAction(chooseDig);

    }

    public static void encryptFileToFile(String fromFile, String toFile, int key) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            int currentChar;

            while ((currentChar = bufferedReader.read()) != -1) {
                char unCipherChar = (char) currentChar;
                char cipherChar;

                if (ALPHABET.contains(unCipherChar)) {
                    int indexUnCipherChar = ALPHABET.indexOf(unCipherChar);

                    if ((indexUnCipherChar + key) >= ALPHABET_SIZE) {
                        cipherChar = ALPHABET.get((indexUnCipherChar + key) % ALPHABET_SIZE);
                    } else if ((indexUnCipherChar + key) < 0) {
                        cipherChar = ALPHABET.get((((key + indexUnCipherChar) % ALPHABET_SIZE) + ALPHABET_SIZE) % ALPHABET_SIZE);
                    } else {
                        cipherChar = ALPHABET.get(indexUnCipherChar + key);
                    }
                    bufferedWriter.write(cipherChar);
                } else {
                    bufferedWriter.write(unCipherChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void decipher(String fromFile, String toFile, int key) {
        int currentKey;
        if (key > 0) {
            currentKey = -key;
        } else {
            currentKey = Math.abs(key);
        }
        encryptFileToFile(fromFile, toFile, currentKey);
    }
}
