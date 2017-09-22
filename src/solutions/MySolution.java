package solutions;

import java.util.ArrayList;
import java.util.List;

public class MySolution implements Solution {
    @Override
    public String reverseString(String word) {
        String reversed = "";
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i > -1; i--) {
            reversed += chars[i];
        }
        return reversed;
    }

    @Override
    public long factorialize(int number) {
        long result = number;
        if (number == 0) {
            return 1;
        }
        for (int i = number-1; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    @Override
    public boolean palindrome(String word) {
        String optimized = word
                .replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (reverseString(optimized).equals(optimized)) {
            return true;
        }
        return false;
    }

    @Override
    public int findLongestWord(String text) {
        List<String> words = new ArrayList<>();
        String word = "";
        for (Character character: text.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                word += character.toString();
            }
            else {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            }
        }
        if (!word.equals("")) {
            words.add(word);
        }
        int max = 0;
        for (String curWord: words) {
            int length = curWord.length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    @Override
    public String titleCase(String text) {
        String[] splitted = text.split("\\s+");
        String[] result = new String[splitted.length];
        for (int i = 0; i < result.length; i++) {
            char[] letters = splitted[i].toCharArray();
            for (int j = 0; j < letters.length; j++) {
                char actual = letters[j];
                if (j == 0) {
                    letters[j] = Character.toUpperCase(actual);
                }
                else {
                    letters[j] = Character.toLowerCase(actual);
                }
            }
            result[i] = String.valueOf(letters);
        }
        return String.join(" ", result);
    }

    @Override
    public int[] largestOfFour(int[][] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int[] row = numbers[i];
            int max = row[0];
            for (int j = 1; j < row.length; j++) {
                if (row[j] > max) {
                    max = row[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    @Override
    public boolean confirmEnding(String word, String end) {
        return false;
    }

    @Override
    public String repeatStringNumTimes(String word, int counter) {
        String result = "";
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                result += word;
            }
        }
        return result;
    }

    @Override
    public String truncateString(String word, int counter) {
        if (counter >= word.length()) {
            return word;
        }
        else {
            if (word.length() > 3) {
                return word.substring(0, counter - 3) + "...";
            }
            else {
                if (word.length() == 1) {
                    return word.substring(0, 1) + "...";
                }
                else {
                    return word.substring(0, counter-1) + "...";
                }
            }
        }
    }

    @Override
    public Object[][] chunkArrayInGroups(Object[] numbers, int counter) {
        int curMax = counter;
        List<Object[]> result = new ArrayList<>();
        List<Object> curList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i < curMax) {
                curList.add(numbers[i]);
            }
            else {
                result.add(curList.toArray());
                curList = new ArrayList<>();
                curList.add(numbers[i]);
            }
        }
        return (Object[][]) result.toArray();
    }

    @Override
    public Object[] slasher(Object[] numbers, int counter) {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i >= counter-1) {
                objects.add(numbers[i]);
            }
        }
        return objects.toArray();
    }

    @Override
    public Object[] destroyer(Object[] numbers, Object... remove) {
        return new Object[0];
    }

    @Override
    public int getIndexToIns(Object[] numbers, float number) {
        return 0;
    }

    private char decodeROT13(char letter) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (Character.isAlphabetic(letter)) {
            int indexInAlphabet = 0;
            for (int i = 0; i < alphabet.length; i++) {
                if (letter == alphabet[i]) {
                    indexInAlphabet = i;
                    break;
                }
            }
            if (indexInAlphabet >= 13) {
                return alphabet[indexInAlphabet - 13];
            }
            else {
                int div = indexInAlphabet - 12;
                return alphabet[alphabet.length - 1 + div];
            }
        }
        else {
            return letter;
        }
    }

    @Override
    public String rot13(String word) {
        String result = "";
        for (char letter: word.toCharArray()) {
            result += String.valueOf(decodeROT13(letter));
        }
        return result;
    }


}