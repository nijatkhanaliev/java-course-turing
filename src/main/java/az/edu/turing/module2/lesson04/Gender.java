package az.edu.turing.module2.lesson04;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String value;

    Gender(String value){
        this.value = value;
    }

    public static Gender getGenderByName(String genderName){
        return Gender.valueOf(genderName);
    }

    public String getValue(){
        return this.value;
    }

}
