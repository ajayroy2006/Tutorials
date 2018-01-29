package extractInjectKillDeepInheritanceHierarchy;

class PricingService {
    private final VoucherService voucherService;
    private final PriceCalculation priceCalculation;
    public PricingService(VoucherService v, PriceCalculation pc) {
        voucherService = v;
        priceCalculation = pc;
    }
    public double calculatePrice(ShoppingBasket shoppingBasket,
            User user, String voucher) {
        double discount = calculateDiscount(user);
        double total = 0;
        for (ShoppingBasket.Item item : shoppingBasket.items()) {
            total += priceCalculation.calculateProductPrice(
                    item.getProduct(), item.getQuantity());
        }
        total = applyAdditionalDiscounts(total, user, voucher);
        return total * ((100 - discount) / 100);
    }
    double calculateDiscount(User user) {
        int discount = 0;
        if (user.isPrime()) {
            discount = 10;
        }
        return discount;
    }
    double applyAdditionalDiscounts(double total, User user,
            String voucher) {
        double voucherValue = voucherService.getVoucherValue(voucher);
        double totalAfterValue = total - voucherValue;
        return (totalAfterValue > 0) ? totalAfterValue : 0;
    }
}

interface PriceCalculation {
    double calculateProductPrice(Product product, int quantity);
}

class StandardPriceCalculation implements PriceCalculation {
    public double calculateProductPrice(Product product, int quantity) {
        return product.getPrice() * quantity;
    }
}

class BoxingDayPriceCalculation implements PriceCalculation {
    public static final double BOXING_DAY_DISCOUNT = 0.60;
    public double calculateProductPrice(Product product, int quantity) {
        return ((product.getPrice() * quantity) * BOXING_DAY_DISCOUNT);
    }
}

//To avoid compilation errors, the following classes are created
class Product {
    public double getPrice() {
        return 0;
    }
}

class VoucherService {
    public double getVoucherValue(String voucher) {
        return 0;
    }
}

class User {
    public boolean isPrime() {
        return false;
    }
}

class ShoppingBasket {
    class Item {
        public Product getProduct() {
            return null;
        }
        public int getQuantity() {
            return 0;
        }
    }
    public Item[] items() {
        return null;
    }
}
