package az.edu.turing.module2.lesson04;

import java.util.Arrays;

public final class User {
    private final StringBuilder name;
    private final String surname;
    private final Gender gender;
    private final int[] arr;

    public User(StringBuilder name, String surname, Gender gender, int[] arr) {
        this.name = new StringBuilder(name);
        this.surname = surname;
        this.gender = gender;
        this.arr = arr;
    }

    public StringBuilder getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public int[] getArr() {
        return Arrays.copyOf(arr, arr.length);
    }
}
