package az.edu.turing.module3.lesson07.json;

import az.edu.turing.module3.lesson07.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User("Nijat",20,"112458");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user.json"),user);


        User user1 = mapper.readValue(new File("user.json"),User.class);
        System.out.println(user1);
    }
}
