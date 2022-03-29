package ru.java.courses;

public class Lesson1 {

    public static void main(String[] args) {
        char a = 'a';
        System.out.println( (char) (a+1) );
    }

}

class Main {
    private static final String ALPHABET = "абвгдежзиклмнопрстуфхцчшщъыьэюя.,«»\"\':!? ]";

    public static String Coder(String text, int key){
        StringBuilder result = new StringBuilder();

        for(int i=0;i<text.length();i++){
            result.append(ALPHABET.charAt((ALPHABET.indexOf(text.charAt(i)) + key) % ALPHABET.length()));
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static String Decoder(String text, int key){
        StringBuilder result = new StringBuilder();
        int new_index;
        for(int i=0;i<text.length();i++){

            new_index = (ALPHABET.indexOf(text.charAt(i)) - key) % ALPHABET.length();

            if(new_index < 0){
                new_index = ALPHABET.length() + new_index;
            }

            result.append(ALPHABET.charAt(new_index));
        }
        return result.toString();
    }

    public static String bruteforce(String s) {
        int key = 1;
        String s1 = s;

        while(key < ALPHABET.length()+30){ //
            s1 = Decoder(s, key);
            System.out.println(s1);
            System.out.println(key);
            key += 1;
        }
        return s1;
    }

    public static void main(String[] args) {
        String s = Coder(ALPHABET, 7);
        bruteforce(s);
    }
}
