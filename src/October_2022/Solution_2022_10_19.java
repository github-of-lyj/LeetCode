package October_2022;

import org.junit.jupiter.api.Test;

public class Solution_2022_10_19 {
    public int countStudents(int[] students, int[] sandwiches) {
        int student = 0;
        int sandwich = 0;
        int count = 0;
        int person = 0;
        while(student != students.length){
            if (students[student] == sandwiches[sandwich]){
                person = 0;
                student++;
                sandwich++;
                count++;
            }else{
                int temp = students[student];
                for(int i = student;i < students.length-1;i++){
                    students[i] = students[i+1];
                }
                students[students.length-1] = temp;
                person++;
            }
            if (person == students.length-student)
                break;
        }
        return students.length-count;
    }

    public void test(int[] arr){
        arr[0] = 1;
        arr[1] = 100;
    }


    @Test
    void test(){
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        test(students);
        for (Integer integer : students) {
            System.out.println(integer);

        }

//        System.out.println(countStudents(students, sandwiches));


    }


}
