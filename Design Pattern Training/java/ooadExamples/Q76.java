package deepInheritanceHierarchy;
abstract class PricingService {
    public double calculatePrice(ShoppingBasket shoppingBasket,
            User user, String voucher) {
        double discount = calculateDiscount(user);
        double total = 0;
        for (ShoppingBasket.Item item : shoppingBasket.items()) {
            total += calculateProductPrice(item.getProduct(),
                    item.getQuantity());
        }
        total = applyAdditionalDiscounts(total, user, voucher);
        return total * ((100 - discount) / 100);
    }
    protected abstract double calculateDiscount(User user);
    protected abstract double calculateProductPrice(Product product,
            int quantity);
    protected abstract double applyAdditionalDiscounts(double total,
            User user, String voucher);
}

abstract class UserDiscountPricingService extends PricingService {
    @Override
    protected double calculateDiscount(User user) {
        int discount = 0;
        if (user.isPrime()) {
            discount = 10;
        }
        return discount;
    }
}

abstract class VoucherPricingService extends
        UserDiscountPricingService {
    private VoucherService voucherService;
    @Override
    protected double applyAdditionalDiscounts(double total,
            User user, String voucher) {
        double voucherValue = voucherService.getVoucherValue(voucher);
        double totalAfterValue = total - voucherValue;
        return (totalAfterValue > 0) ? totalAfterValue : 0;
    }
    public void setVoucherService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }
}

class StandardPricingService extends VoucherPricingService {
    @Override
    protected double calculateProductPrice(Product product,
            int quantity) {
        return product.getPrice() * quantity;
    }
}

class BoxingDayPricingService extends VoucherPricingService {
    public static final double BOXING_DAY_DISCOUNT = 0.60;
    @Override
    protected double calculateProductPrice(Product product,
            int quantity) {
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
