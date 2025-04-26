package az.edu.turing.module3.lesson05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(new User(1, "nicat"), new User(1, "saiq"),
                new User(3, "rasul"), new User(4, "malik"));


        Map<Integer, User> map = users.stream()
                .collect(Collectors.toMap(User::getId, user -> user,(user1,user2)->user1));

        System.out.println(map);

    }
}
