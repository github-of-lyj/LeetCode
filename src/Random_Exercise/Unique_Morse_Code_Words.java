package Random_Exercise;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String, Integer> translation = new HashMap<>();
        String[] Morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String str : words) {
            String MorseStr = "";
            for (int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                int index = c-'a';
                MorseStr+=Morse[index];
            }
            if (translation.containsKey(MorseStr))
                translation.put(MorseStr,translation.get(MorseStr)+1);
            else
                translation.put(MorseStr,1);
        }
        return translation.size();
    }


    @Test
    void Test(){
        char c = 'c';
        int index = c-'a';
        System.out.println(index);
    }
}
