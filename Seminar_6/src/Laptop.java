public class Laptop {
    private final String model;
    private final int hardDisk;
    private final int operativeMemory;
    private final String operatingSystem;
    private final String color;

    public Laptop(String model, int hardDisk, int operativeMemory, String operatingSystem, String color) {
        this.model = model;
        this.hardDisk = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    public int getHardDisk() {
        return hardDisk;
    }

    public int getOperativeMemory() {
        return operativeMemory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "\nМодель " + model + ": "
                + "\nОбъем оперативной памяти = " + operativeMemory + " ГБ "
                + "\nОбъем жесткого диска = " + hardDisk + " ГБ "
                + "\nОперационная система = " + operatingSystem
                + "\nЦвет = " + color + ";" + "\n";
    }
}