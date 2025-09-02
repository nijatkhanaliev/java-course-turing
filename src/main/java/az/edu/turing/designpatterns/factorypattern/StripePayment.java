package az.edu.turing.designpatterns.factorypattern;

public class StripePayment implements Payment{
    @Override
    public void pay() {
        System.out.println("stripe payment");
    }
}
