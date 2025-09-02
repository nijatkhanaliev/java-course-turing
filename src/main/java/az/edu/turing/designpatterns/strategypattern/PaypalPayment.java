package az.edu.turing.designpatterns.strategypattern;

public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("paypal payment");
    }
}
