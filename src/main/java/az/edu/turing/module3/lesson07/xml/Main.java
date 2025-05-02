package az.edu.turing.module3.lesson07.xml;

import az.edu.turing.module3.lesson07.User;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User("nijat",21,"14587");
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new FileOutputStream("user.xml"),user);


        User u = mapper.readValue(new File("user.xml"),User.class);
        System.out.println(u);
    }
}
