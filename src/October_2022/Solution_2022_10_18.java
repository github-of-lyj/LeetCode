package October_2022;

import org.junit.jupiter.api.Test;

public class Solution_2022_10_18 {
    public int findsmall(String[] digits,int n,int place){
        int count = 0;
        int number;
        int next;
        int wei;
        next = n%(int) Math.pow(10,place-1);
        wei =  n/(int) Math.pow(10,place-1);
        for (int i = 0;i < digits.length;i++){
            if (place==1){
                for(int m = 0;m < digits.length;m++){
                    if (Integer.valueOf(digits[m]) < wei){
                        count+=1;
                    }
                }
                break;
            }

            if (Integer.valueOf(digits[i]) < wei){
                count+=Math.pow(digits.length,place-1);
            }
            if (Integer.valueOf(digits[i]) == wei){
                count+=findsmall(digits,next,place-1);
            }
        }

        return count;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int count = 0;
        int test = 10;
        int place = 1;
        int temp = n;
        while(temp%test != n){
            test=test*10;
            place++;
        }
        for (int i = 1;i < place;i++){
             count+=Math.pow(digits.length,i);
        }
        count+=findsmall(digits,n,place);
        return count;
    }

    @Test
    void Test(){
        String[] digits = {"1","3","5","7"};
        String[] digits2 = {"9"};
//        System.out.println(atMostNGivenDigitSet(digits2, 55));
        System.out.println(atMostNGivenDigitSet(digits, 100));

    }
}
