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


    public Vignere (String newPhrase, String encryptionPhrase) {
        this.phrase = newPhrase;
        this.key = encryptionPhrase;

    }

    /* public void createEncodeMap (char letter, int key) {
        charMap = new HashMap<>();
        int converted = 0;

        if (isLowerCase(letter)) {
            converted = ((int) letter - (int) 'a' + key) % 26 + (int) 'a';
        }
        else if (isUpperCase(letter)) {
            converted = ((int) letter - (int) 'A' + key) % 26 + (int) 'A';
        }
        charMap.put(letter, (char)converted);
    } */


    @Override
    public String encode() {

        int keycount = 0;
        String encrytedText =  "";


        // iterate through string
        for (int i=0; i < this.phrase.length(); i++)
        {
            // key is stored in the argv[1] from the command line, loop through the characters in the key
            int key = (int)this.key.charAt(keycount);

            // adjust key to refer to the position in the alphabet, not ASCII table
            if (isLowerCase(key))
            {
                key = key-97;
            }
            if (isUpperCase(key))
            {
                key = key-65;
            }

            // if the "i"th character of the string is a letter proceed with encryption
            //if isalpha(v[i])
            char c = this.phrase.charAt(i);
            Caesar.createEncodeMap(c, key);
            encrytedText += charMap.get(c);
            keycount++;
        }
        return encrytedText;
    }

    @Override
    public String decode() {
    return "hi";
    }


    }
