package twosigma;

import java.util.HashSet;
import java.util.Set;

/**
 * Created  on 5/29/17.
 * The sentence "A quick brown fox jumps over the lazy dog" contains every single letter in the alphabet.

 Such sentences are called pangrams. You are to write a method getMissingLetters, which takes a String,

 sentence, and returns all the letters it is missing (which prevent it from being a pangram). You should

 ignore the case of the letters in sentence, and your return should be all lower case letters, in

 alphabetical order.

 You should also ignore all non US-ASCII characters.

 The code you submit must contain a method that conforms to the expected method signature, as

 follows:

 Java Definition

 Public Class: MissingLetters

 Method signature: public String getMissingLetters(String sentence)

 Examples:

 (Note that in the examples below, the double quotes should not be considered part of the input or

 output strings.)

 0)  "A quick brown fox jumps over the lazy dog"

 Returns: ""

 (This sentence contains every letter)

 1)  "A slow yellow fox crawls under the proactive dog"

 Returns: "bjkmqz"

 2)  "Lions, and tigers, and bears, oh my!"

 Returns: "cfjkpquvwxz"

 3)  ""

 Returns: "abcdefghijklmnopqrstuvwxyz";
 */
public class PangramsMissingLetters {

    public static void main(String[] args) {
        System.out.println("Result:"+getMissingLetters("A quick brown fox jumps over the lazy dog"));
        System.out.println("Result:"+getMissingLetters("A slow yellow fox crawls under the proactive dog"));
        System.out.println("Result:"+getMissingLetters("Lions, and tigers, and bears, oh my!"));
    }

    public static String getMissingLetters(String sentence){
        Set<Character> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            set.add(c);
        }
        for(char c: sentence.toCharArray()){
            char c1 = Character.toLowerCase(c);
            set.remove(c1);
            if(set.size()==0)
                return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char c : set){
            sb.append(c);
        }
        return sb.toString();
    }
}
