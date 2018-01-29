/* This is an embedded application controlling a cooker. 
 * In every second, it will check if the cooker is over-heated 
 * (e.g., short-circuited). If yes it will cut itself off the power 
 * and make an alarm using its built-in speaker. It will also check 
 * if the moisture inside is lower than a certain threshold 
 * (e.g., the rice is cooked). If yes, it will turn its built-in heater 
 * to 50 degree Celsius just to keep the rice warm. 
 * In the future, you expect that some more things will need to be 
 * done in every second.
 * Remove the problem in the code.
 */
class Scheduler extends Thread {
    Alarm alarm;
    HeatSensor heatSensor;
    PowerSupply powerSupply;
    MoistureSensor moistureSensor;
    Heater heater;
    public void run() {
        for (;;) {
            Thread.sleep(1000);
            //check if it is overheated.
            if (heatSensor.isOverHeated()) {
                powerSupply.turnOff();
                alarm.turnOn();
            }
            //check if the rice is cooked.
            if (moistureSensor.getMoisture()<60) {
                heater.setTemperature(50);
            }
        }
    }
}
