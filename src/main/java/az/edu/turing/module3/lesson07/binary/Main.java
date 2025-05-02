package az.edu.turing.module3.lesson07.binary;

import az.edu.turing.module3.lesson07.User;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("nicat",18,"123456");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.obj"));
        outputStream.writeObject(user);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.obj"));
        User user1 = (User) inputStream.readObject();
        System.out.println(user1);
    }
}
