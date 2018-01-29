class Scheduler extends Thread {
    Runnable tasks[];
    void registerTask(Runnable task) {
        //add task to tasks;
    }
    public void run() {
        for (;;) {
            Thread.sleep(1000);
            for (int i = 0; i < tasks.length; i++) {
                tasks[i].run();
            }
        }
    }
}
class OverHeatCheckTask implements Runnable {
    Alarm alarm;
    PowerSupply powerSupply;
    HeatSensor heatSensor;
    public void run() {
        if (heatSensor.isOverHeated()) {
            powerSupply.turnOff();
            alarm.turnOn();
        }
    }
}
class RiceCookedCheckTask implements Runnable {
    Heater heater;
    MoistureSensor moistureSensor;
    public void run() {
        if (moistureSensor.getMoisture()<60) {
            heater.setTemperature(50);
        }
    }
}
class Cooker {
    public static void main(String args[]) {
        Scheduler scheduler = new Scheduler();
        scheduler.registerTask(new OverHeatCheckTask());
        scheduler.registerTask(new RiceCookedCheckTask());
    }
}
