import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import java.util.HashMap;


/**
 * Created by melissa on 5/7/15.
 */
public class Vignere implements Encodable {

    private String phrase;
    private String key;
    private HashMap<Character, Character> charMap;


    public Vignere(String newPhrase, String encryptionPhrase) {
        this.phrase = newPhrase;
        this.key = encryptionPhrase;

    }

    public char createEncodeMap(char letter, int key) {
        charMap = new HashMap<>();
        int converted = 0;

        if (isLowerCase(letter)) {
            converted = ((int) letter - (int) 'a' + key) % 26 + (int) 'a';
        } else if (isUpperCase(letter)) {
            converted = ((int) letter - (int) 'A' + key) % 26 + (int) 'A';
        }
        charMap.put(letter, (char) converted);
        return charMap.get(letter);
    }


    @Override
    public String encode() {

        int keycount = 0;
        String encrytedText = "";


        // iterate through string
        for (int i = 0; i < this.phrase.length(); i++) {

            int key = (int) this.key.charAt(keycount);

            // adjust key to refer to the position in the alphabet, not ASCII table
            if (isLowerCase(key)) {
                key = key - 97;
            }
            if (isUpperCase(key)) {
                key = key - 65;
            }

            char c = this.phrase.charAt(i);
            if (Character.isLetter(c)) {
                encrytedText += createEncodeMap(c, key);
            }
            keycount++;

            if (keycount == this.key.length()) {
                //reset position in key
                keycount = 0;
            }
        }
        return encrytedText;

    }

    @Override
    public String decode() {

        int keycount = 0;
        String decrytedText = "";

        // iterate through string
        for (int i = 0; i < this.phrase.length(); i++) {

            int key = (int) this.key.charAt(keycount);

            // adjust key to refer to the position in the alphabet, not ASCII table
            if (isLowerCase(key)) {
                key = key - 97;
            }
            if (isUpperCase(key)) {
                key = key - 65;
            }

            char c = this.phrase.charAt(i);
            if (Character.isLetter(c)) {
                decrytedText += createEncodeMap(c, -key);
            }
            keycount++;

            if (keycount == this.key.length()) {
                //reset position in key
                keycount = 0;
            }
        }
        return decrytedText;

    }


    public static void main(String args[]) {
        Vignere text1 = new Vignere("Hello", "abc");
        Vignere text2 = new Vignere("Hfnlp", "abc");
        System.out.println(text1.encode());
        System.out.println(text2.decode());


    }
}