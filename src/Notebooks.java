public class Notebooks extends Categories{
    private int RAM;
    private int SSD;
    private double ScreenSize;

    public Notebooks(int ID, double price, int discount, int stock, String name, Brands brand, int RAM, int SSD, double screenSize) {
        super(ID, price, discount, stock, name, brand);
        this.RAM = RAM;
        this.SSD = SSD;
        this.ScreenSize = screenSize;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getSSD() {
        return SSD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(double screenSize) {
        ScreenSize = screenSize;
    }
}
