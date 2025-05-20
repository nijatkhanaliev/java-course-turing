package az.edu.turing.module3.lesson09;

public enum CustomerType {
    MEMBER(new MemberPriceStrategy()),
    REGULAR(new RegularPriceStrategy()),
    VIP(new VipPriceStrategy());

    private final PriceService priceService;

    CustomerType(PriceService priceStrategy){
        this.priceService = priceStrategy;
    }

    public double price(double basePrice){
       return priceService.price(basePrice);
    }

}
