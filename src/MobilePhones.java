
public class MobilePhones extends Categories {
    private int Memory;
    private double ScreenSize;
    private int Battery;
    private int RAM;
    private String Colour;

    public MobilePhones(int ID, double price, int discount, int stock, String name, Brands brand, int memory, double screenSize, int battery, int RAM, String colour) {
        super(ID, price, discount, stock, name, brand);
        this.Memory = memory;
        this.ScreenSize = screenSize;
        this.Battery = battery;
        this.RAM = RAM;
        this.Colour = colour;
    }

    public int getMemory() {
        return Memory;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(double screenSize) {
        ScreenSize = screenSize;
    }

    public int getBattery() {
        return Battery;
    }

    public void setBattery(int battery) {
        Battery = battery;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }
}
