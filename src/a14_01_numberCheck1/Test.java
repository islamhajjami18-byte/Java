package a14_01_numberCheck1;

import test.test;

public class Test {
    public static void main(String args[]) {

        SumTotal();
        SumTotal();
        SumTotal();

    }

    public static void SumTotal() {
        int total = 0;
        for (int i = 0; i <= 10; i++) {
            total += i; 
        }
        System.out.println(total);
    }
}

