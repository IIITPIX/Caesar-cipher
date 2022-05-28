package ua.com.javarush.belmeha.module1;

import java.util.Scanner;

public class Dialog {

    public static void greeting() {
        System.out.println("Приветсвутю вас в программе \"Шифт Цезаря!\"");
        System.out.println("*****************************");
        System.out.println("Выберите действие:\n 1:Зашифровать выбранный файл\n 2:Расшифровать выбранный файл\n 3:Расшифровать с помощью BruteForce ");
        System.out.println("*****************************");
    }

    public static void selectAction(String selectDig) {
        Scanner s = new Scanner(System.in);
        String fileFrom = null;
        String fileTo = null;
        String key = null;
        if ("1".equals(selectDig)) {
            try {
                fileFrom = Validate.validatePath(s, System.out, "Введите путь к файлу, который хотите зашифровать:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                fileTo = Validate.validatePath(s, System.out, "Введите путь к файлу, куда вы хотите сохранить зашифрованный файл:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Введите ключ");
                key = s.nextLine();
                Validate.isItDig(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Main.encryptFileToFile(fileFrom, fileTo, Integer.parseInt(key));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Файл успешно зашифрован в: " + fileTo);

        }

        if ("2".equals(selectDig)) {
            try {
                fileFrom = Validate.validatePath(s, System.out, "Введите путь к файлу, который хотите расшифровать:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                fileTo = Validate.validatePath(s, System.out, "Введите путь к файлу, куда вы хотите сохранить расшифрованный файл:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Введите ключ");
                key = s.nextLine();
                Validate.isItDig(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Main.decipher(fileFrom, fileTo, Integer.parseInt(key));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Файл успешно расшифрован в: " + fileTo);

        }

        if ("3".equals(selectDig)) {
            try {
                fileFrom = Validate.validatePath(s, System.out, "Введите путь к файлу, который хотите расшифровать:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                fileTo = Validate.validatePath(s, System.out, "Введите путь к файлу, куда вы хотите сохранить расшифрованный файл:");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                int keyFromBruteForce = BruteForce.findKeyForBruteForce(fileFrom);
                System.out.println("Скорее всего ключ: "+keyFromBruteForce);
                Main.decipher(fileFrom, fileTo, keyFromBruteForce);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Файл расшифрован в: " + fileTo);

        }
    }
}
