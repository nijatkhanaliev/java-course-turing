package az.edu.turing.module3.lesson09;

public class MemberPriceStrategy implements PriceService{
    @Override
    public double price(double basePrice) {
        return basePrice * 0.8;
    }
}
