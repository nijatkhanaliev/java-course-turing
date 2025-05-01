package az.edu.turing.module3.lesson06.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("nicat.txt");
        try {
            Files.writeString(path, "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Path p = Paths.get("salam.txt");
        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(Arrays.toString(bytes));
            while (!Files.isWritable(p)) {
                Files.createFile(p);
            }
            Files.write(p, bytes, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
