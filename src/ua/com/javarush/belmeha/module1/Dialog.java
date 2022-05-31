package ua.com.javarush.belmeha.module1;

import java.util.Scanner;

public class Dialog {
    private static final String DIALOG_1 = "1";
    private static final String DIALOG_2 = "2";
    private static final String DIALOG_3 = "3";

    public static void greeting() {
        System.out.println("Приветсвутю вас в программе \"Шифт Цезаря!\"");
        System.out.println("*****************************");
        System.out.println("Выберите действие: ( Введите цифру )\n 1 - Зашифровать выбранный файл\n 2 - Расшифровать выбранный файл\n 3 - Расшифровать с помощью BruteForce ");
        System.out.println("*****************************");
    }

    public static void selectAction(String selectDig) {
        Scanner scanner = new Scanner(System.in);
        String fileFrom;
        String fileTo;
        String key;
        if (DIALOG_1.equals(selectDig)) {

            fileFrom = Validate.validatePath(scanner, System.out, "Введите путь к файлу, который хотите зашифровать:");
            fileTo = Validate.validatePath(scanner, System.out, "Введите путь к файлу, куда вы хотите сохранить зашифрованный файл:");
            System.out.println("Введите ключ");
            key = scanner.nextLine();
            Validate.isItDig(key);

            Main.encryptFileToFile(fileFrom, fileTo, Integer.parseInt(key));
            System.out.println("Файл успешно зашифрован в: " + fileTo);

        }

        if (DIALOG_2.equals(selectDig)) {

            fileFrom = Validate.validatePath(scanner, System.out, "Введите путь к файлу, который хотите расшифровать:");
            fileTo = Validate.validatePath(scanner, System.out, "Введите путь к файлу, куда вы хотите сохранить расшифрованный файл:");
            System.out.println("Введите ключ");
            key = scanner.nextLine();
            Validate.isItDig(key);

            Main.decipher(fileFrom, fileTo, Integer.parseInt(key));
            System.out.println("Файл успешно расшифрован в: " + fileTo);

        }

        if (DIALOG_3.equals(selectDig)) {

            fileFrom = Validate.validatePath(scanner, System.out, "Введите путь к файлу, который хотите расшифровать:");
            fileTo = Validate.validatePath(scanner, System.out, "Введите путь к файлу, куда вы хотите сохранить расшифрованный файл:");

            int keyFromBruteForce = BruteForce.findKeyForBruteForce(fileFrom);
            System.out.println("Скорее всего ключ: " + keyFromBruteForce);
            Main.decipher(fileFrom, fileTo, keyFromBruteForce);
            System.out.println("Файл расшифрован в: " + fileTo);

        }
    }
}
