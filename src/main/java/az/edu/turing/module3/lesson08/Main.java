package az.edu.turing.module3.lesson08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("nicat.txt", true))) {
                    writer.write("salam");
                } catch (IOException e) {
                    System.out.println("Write salam method " + e.getMessage());
                }
            });
            if (i == 3) {
                thread.setPriority(8);
            } else if (i == 2) {
                thread.setPriority(4);
            }
            thread.start();
        }

    }
}
