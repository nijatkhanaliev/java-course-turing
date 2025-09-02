package az.edu.turing.designpatterns.strategypattern;

public class PaymentContext {

    private final PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(){
        paymentStrategy.pay();
    }

}
