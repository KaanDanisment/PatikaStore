public abstract class Categories {
    private int ID;
    private double Price;
    private int Discount;
    private int Stock;
    private String Name;
    private Brands Brand;

    public Categories(int ID, double price, int discount, int stock, String name, Brands brand) {
        this.ID = ID;
        this.Price = price;
        this.Discount = discount;
        this.Stock = stock;
        this.Name = name;
        this.Brand = brand;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Brands getBrand() {
        return Brand;
    }

    public void setBrand(Brands brand) {
        Brand = brand;
    }
}
