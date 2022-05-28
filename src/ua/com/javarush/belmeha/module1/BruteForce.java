package ua.com.javarush.belmeha.module1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class BruteForce {

    public static int findKeyForBruteForce(String fileForBrute){

        HashMap<Character, Integer> hashMap = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForBrute));
            hashMap = new HashMap<>();
            int currentChar;

            while ((currentChar = bufferedReader.read()) != -1) {
                Character character = (char)currentChar;
                if (!hashMap.containsKey(character)){
                    hashMap.put(character, 1);
                } else {
                    int countChar = hashMap.get(character);
                    hashMap.put(character, countChar+1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int maxValue = Collections.max(hashMap.values());
        char maxValueChar = 0;
        for (Character key: hashMap.keySet()) {
            if (hashMap.get(key) == maxValue) {
                maxValueChar = key;
            }
        }
        int indexEncryptedSpace = Main.ALPHABET.indexOf(maxValueChar);
        int indexDecipheredSpace = Main.ALPHABET.indexOf(' ');
        return ((Main.ALPHABET_SIZE+indexEncryptedSpace)-indexDecipheredSpace)%Main.ALPHABET_SIZE;
    }

}
