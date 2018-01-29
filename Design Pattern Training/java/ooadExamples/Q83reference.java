/* Point out the problem in the code below. Further suppose that 
 * you need to reuse the heat sensor code in another application. 
 * What should you do?
 */
class Cooker {
    HeatSensor heatSensor;
    Speaker speaker;
    void alarm() {
        speaker.setFrequency(Speaker.HIGH_FREQUENCY);
        speaker.turnOn();
    }
}
class HeatSensor {
    Cooker cooker;
    HeatSensor(Cooker cooker) {
        this.cooker = cooker;
    }
    void checkOverHeated() {
        if (isOverHeated()) {
            cooker.alarm();
        }
    } 
    boolean isOverHeated() {
        ...
    }
}