interface Alarm {
    void turnOn();
}
class Cooker {
    HeatSensor heatSensor;
    Speaker speaker;
    Alarm getAlarm() {
        return new Alarm() {
            void turnOn() {
                speaker.setFrequency(Speaker.HIGH_FREQUENCY);
                speaker.turnOn();
            }
        };
    }
}
class HeatSensor {
    Alarm alarm;
    HeatSensor(Alarm alarm) {
        this.alarm = alarm;
    }
    void checkOverHeated() {
        if (isOverHeated()) {
            alarm.turnOn();
        }
    }
    ...
}