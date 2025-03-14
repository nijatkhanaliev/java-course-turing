package az.edu.turing.module2.lesson03;

public interface Flyable {
    void fly();
    default String getMaskedName(String name){
        String nm = name.substring(1).replaceAll("[A-Za-z]","*");

        return name.substring(0,1).concat(nm);
    }
    static String getMaskedName(int card){
        String cardNumbers = String.valueOf(card);

        String nm = cardNumbers.substring(1).replaceAll("[0-9]","*");

        return cardNumbers.substring(0,1).concat(nm);
    }
}
