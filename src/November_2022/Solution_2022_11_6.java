package November_2022;

import java.util.IllegalFormatCodePointException;

public class Solution_2022_11_6 {
    public String interpret(String command) {
        String str = "";
        for (int i = 0;i < command.length();i++){
            if (command.charAt(i) == 'G')
                str+="G";
            if (command.charAt(i) == ')'){
                if (command.charAt(i) == 'l')
                    str+="al";
                else
                    str+="o";
            }
        }
        return str;
    }
}
