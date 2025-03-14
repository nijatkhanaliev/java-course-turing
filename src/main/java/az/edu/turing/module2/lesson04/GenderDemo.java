package az.edu.turing.module2.lesson04;


public class GenderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Nijat");
        String enteredGender = "male".toUpperCase();
        Gender userGender = Gender.valueOf(enteredGender);

//        for(Gender gender : Gender.values()){
//            if(enteredGender.equalsIgnoreCase(gender.toString())){
//                userGender = gender;
//            }
//        }

        System.out.println(Gender.MALE.getValue());

        User user = new User(stringBuilder,"Khanaliev",userGender,new int[]{1,2,3,4});

        user.getArr()[0]=35;
        stringBuilder.append(" hello");

        System.out.println(user.getName());
        System.out.println(user.getArr()[0]);
        System.out.println(user.getGender() + "  " + user.getGender().ordinal());
    }
}
