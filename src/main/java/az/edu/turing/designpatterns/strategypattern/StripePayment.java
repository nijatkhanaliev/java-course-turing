package az.edu.turing.designpatterns.strategypattern;

public class StripePayment implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("stripe payment");
    }
}
