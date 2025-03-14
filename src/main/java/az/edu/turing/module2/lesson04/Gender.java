package az.edu.turing.module2.lesson04;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender getGenderByName(String genderName) {
        for (Gender gender : Gender.values()) {
            if (genderName.equalsIgnoreCase(gender.value)) {
                return gender;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

}
