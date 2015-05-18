import java.util.HashMap;
import static java.lang.Character.*;
import java.io.*;



/**
 * Created by melissa on 5/7/15.
 */
public class Caesar implements Encodable {


    private String phrase;
    private int key;
    private HashMap<Character, Character> charMap;

    public Caesar (String newPhrase, int newKey) {
        if (newKey < 0)
        {
            throw new IllegalArgumentException("Invalid Key, must be greater than 0");
        }
        this.phrase = newPhrase;
        this.key = newKey;
    }

    @Override
    public String encode() {

        String encrytedText = "";

        for (int i = 0; i < this.phrase.length(); i++) {
            char c = this.phrase.charAt(i);
            if (Character.isLetter(c)) {
                createEncodeMap(c);
                encrytedText += charMap.get(c);
            }
            // add the special character, no encoding required
            else encrytedText += c;
        }
        return encrytedText;
    }


    @Override
    public String decode() {
        String decryptedText = "";
        for (int i = 0; i < this.phrase.length(); i++) {
            char c = this.phrase.charAt(i);
            if (Character.isLetter(c)) {
                createEncodeMap(c, -getKey());
                decryptedText += charMap.get(c);
            }
            // add any special characters without decoding
            else decryptedText += c;
        }
        return decryptedText;
    }

    char createEncodeMap(char letter) {
        return createEncodeMap(letter, this.key);
    }

    private char createEncodeMap (char letter, int key) {
        charMap = new HashMap<>();
        int converted = 0;

        if (isLowerCase(letter)) {
            converted = ((int) letter - (int) 'a' + key) % 26 + (int) 'a';
        }
        else if (isUpperCase(letter)) {
            converted = ((int) letter - (int) 'A' + key) % 26 + (int) 'A';
        }
        charMap.put(letter, (char)converted);
        return charMap.get(letter);
    }


    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static void main(String args[]) {
        Caesar text1;
        Caesar text2;

        try {
            text1 = new Caesar("Hello!", 77);
            text2 = new Caesar("If mmp", 1);
        } catch ( IllegalArgumentException iae ) {
            iae.printStackTrace();
            throw iae;
        }

        System.out.println("Encoding: " + text1.getPhrase());
        System.out.println(text1.encode());
        System.out.println("Decoding: " + text2.getPhrase());
        System.out.println(text2.decode());

    }
}
