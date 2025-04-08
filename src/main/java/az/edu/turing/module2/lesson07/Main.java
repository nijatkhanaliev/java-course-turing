package az.edu.turing.module2.lesson07;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            buyCourse(7.4);
        } catch (BalanceNotEnoughException e) {
            System.out.println(e.getMessage());
        }

        Car car = new Bmw();
        car.practice();// practice in bmw class will be called

        System.out.println(divide(1, 0));
    }

    public static void buyCourse(double balance){
        if(balance<10){
            throw new BalanceNotEnoughException("balance is not enough");
        }

        System.out.println("Course bought successfully");
    }

    public static int divide(int a, int b){
        try {
            if(b==0){
                throw new IllegalArgumentException("b equals zero");
            }

            return a/b;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            System.exit(0);
            throw e;
        } finally {
            return 7;
        }
    }

}
