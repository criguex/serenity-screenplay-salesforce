package test.accountsalesforce.utils.randomdata;

import java.util.Random;

public class RandomData {
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max - min) + min);
    }
    public static int getRandomNumberWithOutZero(int min, int max){
        return (int) (Math.random() * (max - min) + min + 1);
    }
    public static String getRandomDescription(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    public static String getRandomString(String text){
        int randomNumber = (int) (Math.random() * (100 - 1) + 1);
        String randomName = text + randomNumber;
        return randomName;
    }

    public static String getRandomNumberForPhone(){
        int randomNumber =  (int) (Math.random() * (3999999999L - 3000000000L) + 3000000000L);
        String phoneNumber = String.valueOf(randomNumber);
        return phoneNumber;
    }

}
