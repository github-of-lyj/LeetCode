package November_2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//小爷不做了
public class Solution_2022_11_10 {
    public int minFindkey(int keynumer, ArrayList<Character> keys, int i, int j, int steps, char[][] room, Boolean[][] mark) {
        if (i < 0 || i >= room.length)
            return Integer.MAX_VALUE;
        if (j < 0 || j >= room[0].length)
            return Integer.MAX_VALUE;
        if (room[i][j] == '#')
            return Integer.MAX_VALUE;
        if (mark[i][j]) {
            return Integer.MAX_VALUE;
        } else {
            mark[i][j] = true;
        }
        if (room[i][j] >= 'A' && room[i][j] <= 'Z') {
            if (!keys.contains((char) (room[i][j] + 32))) {
                return Integer.MAX_VALUE;
            }
        }
        if (room[i][j] >= 'a' && room[i][j] <= 'z') {
            for (int m = 0; m < mark.length; m++) {
                for (int n = 0; n < mark[0].length; n++) {
                    if (room[m][n] >= 'a' && room[m][n] <= 'z') {
                        if (!keys.contains(room[i][j])) {
                            mark[m][n] = false;
                        }
                    } else {
                        mark[m][n] = false;
                    }
                }
            }
            mark[i][j] = true;
            if (!keys.contains(room[i][j])) {
                keys.add(room[i][j]);
                keynumer--;
                if (keynumer == 0)
                    return steps;
            }
        }
        int min;
        int resultA = minFindkey(keynumer, keys, i + 1, j, steps + 1, room, mark);
        int resultB = minFindkey(keynumer, keys, i - 1, j, steps + 1, room, mark);
        int resultC = minFindkey(keynumer, keys, i, j + 1, steps + 1, room, mark);
        int resultD = minFindkey(keynumer, keys, i, j - 1, steps + 1, room, mark);
        min = Math.min(resultA, Math.min(resultB, Math.min(resultC, resultD)));
        return min;
    }

    public int shortestPathAllKeys(String[] grid) {
        int keyNumber = 0;
        Boolean[][] mark = new Boolean[grid[0].length()][grid.length];
        ArrayList<Character> keys = new ArrayList<Character>();
        char[][] room = new char[grid[0].length()][grid.length];
        for (String s : grid) {
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    keyNumber++;
                }
        }
        int index = 0;
        int x = 0;
        int y = 0;
        for (int j = grid.length - 1; j >= 0; j--) {
            for (int i = 0; i < grid[0].length(); i++) {
                room[i][j] = grid[index].charAt(i);
                if (grid[index].charAt(i) == '@') {
                    x = i;
                    y = j;
                }
            }
            index++;
        }
        for (int i = 0; i < grid[0].length(); i++)
            for (int j = 0; j < grid.length; j++)
                mark[i][j] = false;
        int min = minFindkey(keyNumber, keys, x, y, 0, room, mark);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

//    ["@...a",".###A","b.BCc"]

    @Test
    void Test() {
        String[] grid = {"@...a", ".###A", "b.BCc"};
        System.out.println(shortestPathAllKeys(grid));
    }
}