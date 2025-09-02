package az.edu.turing.designpatterns.factorypattern;

public class PaypalPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("paypal payment");
    }
}
