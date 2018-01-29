interface Flyable {
  void fly();
}

class FlyWithWings implements Flyable {
  @Override
  public void fly() {
    System.out.println("Duck flying");
  }
}

class FlyNo implements Flyable {
  @Override
  public void fly() {
    System.out.println("Duck stationary");
  }
}

interface Quackable {
  void speak();
}

class QuackNormal implements Quackable {
  @Override
  public void speak() {
    System.out.println("Duck quacking");
  }
}

class QuackSqueak implements Quackable {
  @Override
  public void speak() {
    System.out.println("Duck squeaking");
  }
}

class QuackNone implements Quackable {
  @Override
  public void speak() {
    System.out.println("Duck silent");
  }
}

abstract class Duck {
  private final Flyable flyingBehaviour;
  private final Quackable quackingBehaviour;

  public Duck(Flyable flyingBehaviour, Quackable quackingBehaviour) {
    this.flyingBehaviour = flyingBehaviour;
    this.quackingBehaviour = quackingBehaviour;
  }

  public void swim() {
    System.out.println("Duck swimming");
  }

  public void display() {
    System.out.println("Duck painted");
  }

  public void fly() {
    flyingBehaviour.fly();
  }

  public void makeNoise() {
    quackingBehaviour.speak();
  }
}

class DecoyDuck extends Duck {
  public DecoyDuck() {
    super(new FlyNo(), new QuackNone());
  }
}

class RedHeadDuck extends Duck {
  public RedHeadDuck() {
    super(new FlyWithWings(), new QuackNormal());
  }
}

class WhiteSmallDuck extends Duck {
  public WhiteSmallDuck() {
    super(new FlyNo(), new QuackNormal());
  }
}

class RubberDuck extends Duck {
  public RubberDuck() {
    super(new FlyNo(), new QuackSqueak());
  }
}

public class Strategy {
  static void process(Duck d) {
    d.swim();
    d.display();
    d.fly();
    d.makeNoise();
  }

  public static void main(String[] args) {
    process(new DecoyDuck()); // Any duck can be passed.
  }

}
