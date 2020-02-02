package com.navin.melalwallet.utils;

import com.navin.melalwallet.ui.kotlin.Student;

public class Utility {

    public static int getMin(int a, int b) {

        if (a > b) {
            return b;
        } else {
            return a;
        }
    }




    public boolean getZoj (int i){
        if (i%2 == 0){
            return true;
        } else {
            return false;
        }
    }



    public void test (){

        Student student = new Student("ali", 20);

        student.getAge();

        student.getName();



    }

}
