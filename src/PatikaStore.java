
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {
    Scanner scan = new Scanner(System.in);
    int nBID = 0;
    int mPID = 0;
    static TreeSet<Brands> brands = new TreeSet<>(new BrandSorting());
    static LinkedHashMap<Integer, Notebooks> notebooks = new LinkedHashMap<>();
    static LinkedHashMap<Integer, MobilePhones> mobilePhones = new LinkedHashMap<>();

    static {
        brands.add(new Brands(1, "Samsung"));
        brands.add(new Brands(2, "Lenovo"));
        brands.add(new Brands(3, "Apple"));
        brands.add(new Brands(4, "Huawei"));
        brands.add(new Brands(5, "Casper"));
        brands.add(new Brands(6, "Asus"));
        brands.add(new Brands(7, "HP"));
        brands.add(new Brands(8, "Xiaomi"));
        brands.add(new Brands(9, "Monster"));
    }


    public void run() {
        System.out.println("-------------Store Management-------------");

        System.out.println("""
                Select what you want to do
                0- Exit
                1- List Products
                2- List Brands
                3- Add new Product
                4- Delete Product
                5- Filter Product
                """);
        int c = scan.nextInt();
        switch (c) {
            case 1:
                System.out.println("""
                        0- Back
                        1- List Mobile Phones
                        2- List Notebooks
                        """);
                int s = scan.nextInt();
                switch (s) {
                    case 1:
                        listMobilePhones();
                        break;
                    case 2:
                        listNotebooks();
                        break;
                    case 0:
                        break;
                }
                run();
                break;
            case 2:
                listBrands();
                run();
                break;
            case 3:
                System.out.println("""
                        0- Back
                        1- Add Notebook
                        2- Add Mobile Phone""");
                int k = scan.nextInt();
                switch (k) {
                    case 0:
                        break;
                    case 1:
                        addNotebook();
                        break;
                    case 2:
                        addMobilePhone();
                        break;
                }
                run();
                break;
            case 4:
                System.out.println("""
                        0- Back
                        1- Delete Notebook
                        2- Delete Mobile Phone
                        """);
                int d = scan.nextInt();
                switch (d){
                    case 0:
                        break;
                    case 1:
                        deleteNotebook();
                        break;
                    case 2:
                        deleteMobilePhone();
                        break;
                }
                run();
                break;
            case 5:
                filterProduct();
                run();
                break;
            case 0:
                break;
        }
    }

    public void filterProduct(){
        System.out.println("""
                0- Back
                1- Filter By ID
                2- Filter By Brand
                """);
        int f = scan.nextInt();

        switch (f){
            case 0:
                break;
            case 1:
                System.out.print("Enter Product ID: ");
                int id = scan.nextInt();
                System.out.println("-----------------------------------------------------------Mobile Phones-------------------------------------------------------------");
                System.out.println("| ID   | Product Name                      | Price     | Brand     | Memory  | Screen Size    | Battery       | RAM       | Colour  |");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                for (Integer i: mobilePhones.keySet()){
                    if (i == id){
                        System.out.printf("|%1$-6d|%2$-35s|%3$-11f|%4$-11s|%5$-10d|%6$-16f|%7$-15s|%8$-11s|%9$-9s|\n",mobilePhones.get(i).getID(), mobilePhones.get(i).getName(), mobilePhones.get(i).getPrice(), mobilePhones.get(i).getBrand().getName(), mobilePhones.get(i).getMemory(), mobilePhones.get(i).getScreenSize(), mobilePhones.get(i).getBattery(), mobilePhones.get(i).getRAM(), mobilePhones.get(i).getColour());
                    };
                }
                System.out.println();
                System.out.println();
                System.out.println("--------------------------------------------Notebooks--------------------------------------------------");
                System.out.println("| ID   | Product Name                      | Price     | Brand     | SSD  | Screen Size     | RAM     |");
                System.out.println("------------------------------------------------------------------------------------------------------");
                for (Integer n: notebooks.keySet()){
                    if (id == n){
                        System.out.printf("|%1$-6d|%2$-35s| %3$-11f| %4$-11s|%5$-6d|%6$-17f|%7$-9d|\n", notebooks.get(n).getID(), notebooks.get(n).getName(), notebooks.get(n).getPrice(), notebooks.get(n).getBrand().getName(), notebooks.get(n).getSSD(), notebooks.get(n).getScreenSize(), notebooks.get(n).getRAM());
                    }
                }
                System.out.println();
                System.out.println();
                break;
            case 2:
                System.out.print("Enter Product Brand: ");scan.nextLine();
                String br = scan.nextLine();
                for (Brands i: brands){
                    if (i.getName().equals(br)){
                        System.out.println("-----------------------------------------------------------Mobile Phones-------------------------------------------------------------");
                        System.out.println("| ID   | Product Name                      | Price     | Brand     | Memory  | Screen Size    | Battery       | RAM       | Colour  |");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                        for (MobilePhones m: mobilePhones.values()){
                            if (m.getBrand().getName().equals(br)){
                                System.out.printf("|%1$-6d|%2$-35s|%3$-11f|%4$-11s|%5$-10d|%6$-16f|%7$-15s|%8$-11s|%9$-9s|\n", m.getID(),m.getName(),m.getPrice(),m.getBrand().getName(), m.getMemory(), m.getScreenSize(), m.getBattery(),m.getRAM(),m.getColour());
                            }
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("--------------------------------------------Notebooks--------------------------------------------------");
                        System.out.println("| ID   | Product Name                      | Price     | Brand     | SSD  | Screen Size     | RAM     |");
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        for (Notebooks n: notebooks.values()){
                            if (n.getBrand().getName().equals(br)){
                                System.out.printf("|%1$-6d|%2$-35s| %3$-11f| %4$-11s|%5$-6d|%6$-17f|%7$-9d|\n", n.getID(), n.getName(), n.getPrice(), n.getBrand().getName(), n.getSSD(), n.getScreenSize(), n.getRAM());
                            }
                        }
                        System.out.println();
                        System.out.println();
                    }
                }
        }

    }

    public void deleteMobilePhone() {
        listMobilePhones();
        System.out.print("Enter the ID of the product you want delete: ");
        int del = scan.nextInt();
        System.out.println();
        if (!mobilePhones.containsKey(del)){
            System.out.println("Product not found at this ID");
        }
        for (Integer mP: mobilePhones.keySet()){
            if (del == mP){
                mobilePhones.remove(mP);
                System.out.println("Product removed succesfully");
            }
        }
        System.out.println();
        System.out.println();

    }

    public void deleteNotebook() {
        listNotebooks();
        System.out.print("Enter the ID of the product you want delete: ");
        int del = scan.nextInt();
        System.out.println();
        if (!mobilePhones.containsKey(del)) {
            System.out.println("Product not found at this ID");
        }
        for (Integer mP: mobilePhones.keySet()){
            if (mP == del){
                mobilePhones.remove(mP);
                System.out.println("Product removed successfully");
            }
        }
        System.out.println();
        System.out.println();
    }

    public void addNotebook() {

        System.out.print("Enter Model Name: ");
        scan.nextLine();
        String nBName = scan.nextLine();

        System.out.print("Enter Selling Price: ");
        double nBPrice = scan.nextDouble();

        System.out.print("Enter Discount(%): ");
        int nBDiscount = scan.nextInt();

        System.out.print("Enter Stock: ");
        int nBStock = scan.nextInt();

        listBrands();

        Brands nBBrand = null;
        boolean process = true;
        while (process) {
            System.out.print("Enter Valid Brand: ");
            String nbBrand = scan.nextLine();
            for (Brands br : brands) {
                if (br.getName().equals(nbBrand)) {
                    nBBrand = br;
                    process = false;
                }
            }
        }

        System.out.print("Enter Notebook's RAM: ");
        int nBRAM = scan.nextInt();

        System.out.print("Enter Notebook's SSD: ");
        int nBSSD = scan.nextInt();

        System.out.print("Enter Notebook's Screen Size: ");
        double nBScreenSize = scan.nextDouble();

        nBID++;

        Notebooks newNotebook = new Notebooks(nBID, nBPrice, nBDiscount, nBStock, nBName, nBBrand, nBRAM, nBSSD, nBScreenSize);
        notebooks.put(nBID, newNotebook);
        System.out.println();
        System.out.println("Product added successfully");
        System.out.println();
        System.out.println();

    }

    public void addMobilePhone() {
        System.out.print("Enter Model Name: ");
        scan.nextLine();
        String mPName = scan.nextLine();

        System.out.print("Enter Selling Price: ");
        double mPPrice = scan.nextDouble();

        System.out.print("Enter Discount(%): ");
        int mPDiscount = scan.nextInt();

        System.out.print("Enter Stock: ");
        int mPStock = scan.nextInt();

        Brands mPBrand = null;
        boolean process = true;
        listBrands();
        while (process) {
            System.out.print("Enter Valid Brand: ");
            String mpBrand = scan.nextLine();
            for (Brands br : brands) {
                if (br.getName().equals(mpBrand)) {
                    mPBrand = br;
                    process = false;
                }
            }
        }

        System.out.print("Enter Mobile Phone's Memory: ");
        int mPMemory = scan.nextInt();

        System.out.print("Enter Mobile Phone's Screen Size: ");
        double mPScreenSize = scan.nextDouble();

        System.out.print("Enter Mobile Phone's Battery: ");
        int mPBattery = scan.nextInt();

        System.out.print("Enter Mobile Phone's RAM: ");
        int mPRAM = scan.nextInt();

        System.out.print("Enter Mobile Phone's Colour: ");scan.nextLine();
        String mPColour = scan.nextLine();

        mPID++;

        MobilePhones newMobilePhone = new MobilePhones(mPID,mPPrice,mPDiscount,mPStock,mPName,mPBrand,mPMemory,mPScreenSize,mPBattery,mPRAM,mPColour);
        mobilePhones.put(mPID,newMobilePhone);
        System.out.println();
        System.out.println("Product added successfully");
        System.out.println();
        System.out.println();

    }


    public static void listBrands() {
        System.out.println("-------------Brands-------------");
        for (Brands br : brands) {
            System.out.println(br.getName());
        }
        System.out.println();
        System.out.println();
    }

    public void listNotebooks() {

        System.out.println("--------------------------------------------Notebooks--------------------------------------------------");
        System.out.println("| ID   | Product Name                      | Price     | Brand     | SSD  | Screen Size     | RAM     |");
        System.out.println("------------------------------------------------------------------------------------------------------");
        for (Notebooks nB : notebooks.values()) {
            System.out.printf("|%1$-6d|%2$-35s| %3$-11f| %4$-11s|%5$-6d|%6$-17f|%7$-9d|\n", nB.getID(), nB.getName(), nB.getPrice(), nB.getBrand().getName(), nB.getSSD(), nB.getScreenSize(), nB.getRAM());
        }
        System.out.println();
        System.out.println();
    }

    public void listMobilePhones() {

        System.out.println("-----------------------------------------------------------Mobile Phones-------------------------------------------------------------");
        System.out.println("| ID   | Product Name                      | Price     | Brand     | Memory  | Screen Size    | Battery       | RAM       | Colour  |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhones mP : mobilePhones.values()) {
            System.out.printf("|%1$-6d|%2$-35s|%3$-11f|%4$-11s|%5$-10d|%6$-16f|%7$-15s|%8$-11s|%9$-9s|\n", mP.getID(),mP.getName(),mP.getPrice(),mP.getBrand().getName(),mP.getMemory(), mP.getScreenSize(), mP.getBattery(),mP.getRAM(),mP.getColour());
        }
        System.out.println();
        System.out.println();
    }
}
