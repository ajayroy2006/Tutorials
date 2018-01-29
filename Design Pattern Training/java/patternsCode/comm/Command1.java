import java.util.HashMap;
import java.util.Map;

class Light {
  public void on() {
    System.out.println("Light on");
  }

  public void off() {
    System.out.println("Light off");
  }
}

class Fan {
  public void fanOn() {
    System.out.println("Fan on");
  }

  public void fanOff() {
    System.out.println("Fan off");
  }
}

interface Command {
  void execute();

  void undo();
}

class FanOn implements Command {
  Fan f;

  public FanOn(Fan f) {
    this.f = f;
  }

  @Override
  public void execute() {
    f.fanOn();
  }

  @Override
  public void undo() {
    f.fanOff();
  }
}

class FanOff implements Command {
  Fan f;

  public FanOff(Fan f) {
    this.f = f;
  }

  @Override
  public void execute() {
    f.fanOff();
  }

  @Override
  public void undo() {
    f.fanOn();
  }
}

class LightOff implements Command {
  Light l;

  public LightOff(Light l) {
    this.l = l;
  }

  @Override
  public void execute() {
    l.off();
  }

  @Override
  public void undo() {
    l.on();
  }
}

class LightOn implements Command {
  Light l;

  public LightOn(Light l) {
    this.l = l;
  }

  @Override
  public void execute() {
    l.on();
  }

  @Override
  public void undo() {
    l.off();
  }
}

class RemoteControl {
  private Map<Integer, Command> buttons = new HashMap<>();
  Light l = new Light();
  Fan f = new Fan();
  Command last;

  public RemoteControl() {
    buttons.put(1, new LightOn(l));
    buttons.put(2, new LightOff(l));
    buttons.put(3, new FanOn(f));
    buttons.put(4, new FanOff(f));
  }

  void buttonPressed(int number) {
    last = buttons.get(number);
    last.execute();
  }

  void undo() {
    last.undo();
  }
}

public class Command1 {
  public static void main(String[] args) {
    RemoteControl rm = new RemoteControl();
    rm.buttonPressed(1);
    rm.buttonPressed(2);
    rm.undo();

  }

}
