package az.edu.turing.module3.lesson06.io;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FileWriter writer = null;
        BufferedWriter bf = null;
        try {
            writer = new FileWriter("salam.txt", true);
            bf = new BufferedWriter(writer);
            bf.write("salam");
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.err.println(e.getMessage());
        } finally {
            if (writer != null && bf != null) {
                try {
                    bf.close();
                    writer.close();
                } catch (IOException e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
                    System.err.println("WRITER WRITE: " + e.getMessage());
                }
            }
        }

        try (FileReader reader = new FileReader("salam.txt");
             BufferedReader br = new BufferedReader(reader)
        ) {

            int read = br.read();
            StringBuilder result = new StringBuilder();
            while (read != -1) {
                result.append((char) read);
                read = br.read();
            }
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.err.println("READER READ: " + e.getMessage());
        }

        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        byte[] arr = null;
        try {
            inputStream = new FileInputStream("salam.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);
            arr = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(arr);
        } catch (IOException e) {
            System.err.println("INPUT STREAM READ: " + e.getMessage());
        } finally {
            if (inputStream != null && bufferedInputStream!=null) {
                try {
                    bufferedInputStream.close();
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println("INPUT STREAM CLOSE: " + e.getMessage());
                }
            }

        }

        try(FileOutputStream outputStream = new FileOutputStream("hello.txt");
            BufferedOutputStream bfs = new BufferedOutputStream(outputStream)) {
            bfs.write(arr);
        }catch (IOException e){
            System.err.println("OUTPUT STREAM WRITE: "  + e.getMessage());
        }

    }

}
