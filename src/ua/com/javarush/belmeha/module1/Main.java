package ua.com.javarush.belmeha.module1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю','я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю','Я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');

    public static void main(String[] args) throws Exception{
        encryptFileToFile("C:\\test\\Example.txt", "C:\\test\\ciphered.txt", -41);
        //decipher("C:\\test\\ciphered.txt", "C:\\test\\unCiphered.txt", 2);
    }

    public static void encryptFileToFile(String fromFile, String toFile, int key) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile));

        int currentChar;

        while ((currentChar = bufferedReader.read()) != -1) {
            char unCipherChar = (char) currentChar;
            char cipherChar;

            if (ALPHABET.contains(unCipherChar)) {
                int indexUnCipherChar = ALPHABET.indexOf(unCipherChar);

                if ((indexUnCipherChar + key) >= ALPHABET.size()) {
                    cipherChar = ALPHABET.get((indexUnCipherChar + key) % ALPHABET.size());
                } else if ((indexUnCipherChar + key) < 0) {
                    cipherChar = ALPHABET.get((((key+indexUnCipherChar)% ALPHABET.size())+40)%40);
                } else {
                    cipherChar = ALPHABET.get(indexUnCipherChar + key);
                }
                System.out.print(cipherChar);
                bufferedWriter.write(cipherChar);
            } else {
                System.out.print(unCipherChar);
                bufferedWriter.write(unCipherChar);
            }
        }
        bufferedWriter.close();
    }
    public static void decipher(String fromFile, String toFile, int key) throws Exception{
        int currentKey;
        if (key > 0) {
            currentKey = -key;
        } else {
            currentKey = Math.abs(key);
        }
        encryptFileToFile(fromFile, toFile, currentKey);
    }
}
