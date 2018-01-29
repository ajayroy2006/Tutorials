import java.util.Observable;
import java.util.Observer;

class WeatherMeasurer extends Observable {
  public void change() {
    setChanged();
    notifyObservers();
  }

  int getTemperature() {
    return 25;
  }
}

class MaxMinTemp implements Observer {
  WeatherMeasurer wm;

  public MaxMinTemp(WeatherMeasurer wm) {
    this.wm = wm;
    wm.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    System.out.printf("Temp changed to %d%n", wm.getTemperature());
  }
}

class Forecaster implements Observer {
  WeatherMeasurer wm;

  public Forecaster(WeatherMeasurer wm) {
    this.wm = wm;
    wm.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    System.out.printf("Forecast changed for temp %d%n", wm.getTemperature());
  }
}

public class ObserverDP {
  public static void main(String[] args) {
    WeatherMeasurer wm = new WeatherMeasurer();
    MaxMinTemp m1 = new MaxMinTemp(wm);
    Forecaster m2 = new Forecaster(wm);
    wm.change();
  }

}
