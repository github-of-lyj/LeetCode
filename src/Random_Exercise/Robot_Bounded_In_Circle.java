package Random_Exercise;

import org.junit.jupiter.api.Test;

import java.util.IllegalFormatCodePointException;

public class Robot_Bounded_In_Circle {
    public boolean isRobotBounded(String instructions) {
        boolean flag = true;
        char direction = 'N';
        int x = 0;
        int y = 0;
        for (int i = 0;i < instructions.length();i++){
            char c = instructions.charAt(i);
            if (c == 'G' && direction == 'N'){
                y++;
                continue;
            }
            if (c == 'G' && direction == 'S'){
                y--;
                continue;
            }
            if (c == 'G' && direction == 'W'){
                x--;
                continue;
            }
            if (c == 'G' && direction == 'E'){
                x++;
                continue;
            }
            if (c == 'L' && direction == 'N'){
                direction = 'W';
                continue;
            }
            if (c == 'R' && direction == 'N'){
                direction = 'E';
                continue;
            }

            if (c == 'L' && direction == 'S'){
                direction = 'E';
                continue;
            }
            if (c == 'R' && direction == 'S'){
                direction = 'W';
                continue;
            }
            if (c == 'L' && direction == 'W'){
                direction = 'S';
                continue;
            }

            if (c == 'R' && direction == 'W'){
                direction = 'N';
                continue;
            }

            if (c == 'L' && direction == 'E'){
                direction = 'N';
                continue;
            }

            if (c == 'R' && direction == 'E'){
                direction = 'S';
                continue;
            }
        }
        if (direction == 'N')
            flag = false;
        if (x == 0 && y == 0)
            flag = true;
        return flag;
    }



    @Test
    void Test(){
        String s = "GL";
        System.out.println(isRobotBounded(s));
    }
}
