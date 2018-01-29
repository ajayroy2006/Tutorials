interface Beverage {
  int cost();

  void dispense();
}

class Tea implements Beverage {
  @Override
  public int cost() {
    return 10;
  }

  @Override
  public void dispense() {
    System.out.println("tea dispensed");
  }
}

class Coffee implements Beverage {
  @Override
  public int cost() {
    return 15;
  }

  @Override
  public void dispense() {
    System.out.println("coffee dispensed");
  }
}

abstract class CondimentDecorator implements Beverage {
  protected Beverage b;

  public CondimentDecorator(final Beverage b) {
    this.b = b;
  }
}

class Milk extends CondimentDecorator {
  public Milk(final Beverage b) {
    super(b);
  }

  @Override
  public int cost() {
    return 2 + b.cost();
  }

  @Override
  public void dispense() {
    b.dispense();
    System.out.println("Milk dispensed");
  }
}

class Sugar extends CondimentDecorator {
  public Sugar(final Beverage b) {
    super(b);
  }

  @Override
  public int cost() {
    return 1 + b.cost();
  }

  @Override
  public void dispense() {
    System.out.println("Sugar dispensed");
    b.dispense();
  }
}

public class Decorator {
  private static void printCost(final Beverage b) {
    System.out.printf("The cost is %d%n", b.cost());
    b.dispense();
  }

  public static void main(final String[] args) {
    printCost(new Sugar(new Milk(new Tea())));
  }
}
