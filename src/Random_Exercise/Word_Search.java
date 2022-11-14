package Random_Exercise;

import org.junit.jupiter.api.Test;

public class Word_Search {
    void InitMarks(Boolean[][] Marks,char[][] board){
        for (int i = 0;i < board.length;i++)
            for (int j = 0;j < board[0].length;j++)
                Marks[i][j] = false;
    }
    Boolean Find(int i,int j,int k ,String word,char[][] board,Boolean[][] Marks){
        if (word.charAt(k) != board[i][j])
            return false;
        else if (k == word.length()-1)
            return true;
        Marks[i][j] = true;





        return true;
    }


    public boolean exist(char[][] board, String word) {
        Boolean flag = false;
        Boolean[][] Marks = new Boolean[board.length][board[0].length];
        InitMarks(Marks,board);
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++)
                flag = Find(i,j,0,word,board,Marks);
        }
        return flag;
    }
}
